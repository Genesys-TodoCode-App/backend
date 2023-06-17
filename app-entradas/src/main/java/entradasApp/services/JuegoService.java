package entradasApp.services;

import entradasApp.entities.Juego;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.repositories.JuegoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {

    private JuegoRepository juegoRepository;

    private JuegoService(JuegoRepository juegoRepository){
        this.juegoRepository = juegoRepository;
    }

    public void create(Juego juego){
        boolean existeJuego = juegoRepository.existsById(juego.getIdJuego());
        if (existeJuego) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe en base de datos este juego");
        }
    }
    public Iterable<Juego> findAll() {
        return juegoRepository.findAll();
    }
    public Juego findById(Long id) {
        return juegoRepository.findById(id)
            .orElse(null);
    }
    public void update(Long id, Juego juego) {
        Juego juegoExistente = juegoRepository.findById(id).orElse(null);
        if (juegoExistente != null) {
            juegoExistente.setNombreJuego(juego.getNombreJuego());
            juegoExistente.setPrecioJuego(juego.getPrecioJuego());
            juegoExistente.setHoraInicio(juego.getHoraInicio());
            juegoExistente.setHoraFin((juego.getHoraFin()));
            juegoExistente.setEmpleadoAutorizado(juego.getEmpleadoAutorizado());
            juegoRepository.save(juegoExistente);
        }

    }
    public void deleteById(Long id) {
        try {
            juegoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el Juego");
        }
    }
}
