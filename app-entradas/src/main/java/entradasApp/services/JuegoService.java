package entradasApp.services;

import entradasApp.entities.Empleado;
import entradasApp.entities.Juego;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import entradasApp.repositories.JuegoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {

    private JuegoRepository juegoRepository;

    private EmpleadoRepository empleadoRepository;

    private JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    public void create(Juego juego) {
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
            juegoExistente.setCobroPaseOro(juego.isCobroPaseOro());
            juegoExistente.setJuegoActivo(juego.isJuegoActivo());
            juegoExistente.setHorarios(juego.getHorarios());
            juegoRepository.save(juegoExistente);
        }

    }

    public void deleteById(Long id) {
        Juego juego = juegoRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontré el juego con el id: " + id));
        juego.setJuegoActivo(false);
        juego.setPrecioJuego(null);
        juego.setCobroPaseOro(false);
        juego.setNombreJuego(null);
        juegoRepository.save(juego);
    }
}
