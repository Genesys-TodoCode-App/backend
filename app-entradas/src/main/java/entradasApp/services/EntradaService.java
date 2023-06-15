package entradasApp.services;

import entradasApp.entities.Entrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EntradaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

    private EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository){
        this.entradaRepository = entradaRepository;
    }

    public void create(Entrada entrada){
        boolean existeEntrada = entradaRepository.existsById(entrada.getIdEntrada());
        if (existeEntrada){
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta entrada en la base de datos");
        }
    }
    public List<Entrada> findAll(){
        return entradaRepository.findAll();
    }
    public Entrada findById(Long id){
        return entradaRepository.findById(id).orElse(null);
    }
    public void update(Long id, Entrada entrada) {
        Entrada entradaExistente = entradaRepository.findById(id).orElse(null);
        if (entradaExistente != null) {
            entradaExistente.setFechaHoraUtilizacion(entrada.getFechaHoraUtilizacion());
            entradaExistente.setJuego(entrada.getJuego());
            entradaExistente.setComprador(entrada.getComprador());
            entradaExistente.setEmpleadoVendedor(entrada.getEmpleadoVendedor());
            entradaRepository.save(entradaExistente);
        } else {
            throw new NoEncontradoExcepcion("La entrada con el Id: " + id + " no ha sido encontrada");
        }
    }
    public void deleteById(Long id) {
        try {
            entradaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la entrada");
        }
    }
}
