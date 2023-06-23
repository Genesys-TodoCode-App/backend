package entradasApp.services;

import entradasApp.entities.HorarioJuego;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.HorarioJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


/**
 * Clase de servicio que maneja las operaciones relacionadas con los horarios de juego.
 * Por cuestiones de seguridad no hay métodos para el borrado total.
 */
@Service
public class HorarioJuegoService {

    @Autowired
    private final HorarioJuegoRepository horarioJuegoRepository;

    /**
     * Constructor de la clase HorarioJuegoService.
     * @param horarioJuegoRepository Repositorio de horarios de juego.
     */
    public HorarioJuegoService(HorarioJuegoRepository horarioJuegoRepository) {
        this.horarioJuegoRepository = horarioJuegoRepository;
    }

    /**
     * Crea un nuevo horario de juego.
     * Si el horario de juego ya existe en la base de datos, se lanza una NoEncontradoExcepcion.
     * @param horarioJuego El horario de juego a crear.
     */
    public void create(HorarioJuego horarioJuego) {
        boolean existeHorarioJuego = horarioJuegoRepository.existsById(horarioJuego.getIdHorarioJuego());
        if (!existeHorarioJuego) {
            horarioJuegoRepository.save(horarioJuego);
        } else {
            throw new NoEncontradoExcepcion("El horario de juego ya existe");
        }
    }

    /**
     * Obtiene todos los horarios de juego y los devuelve como una colección Iterable.
     * @return Una colección Iterable de HorarioJuego que representa a todos los horarios de juego.
     */
    public Iterable<HorarioJuego> findAll() {
        return horarioJuegoRepository.findAll();
    }

    /**
     * Busca un horario de juego por su ID y lo devuelve.
     * Si el horario de juego no existe, se devuelve null.
     * @param id El ID del horario de juego a buscar.
     * @return El HorarioJuego correspondiente al horario de juego encontrado, o null si no se encontró ningún horario de juego.
     */
    public HorarioJuego findById(Long id) {
        return horarioJuegoRepository.findById(id).orElse(null);
    }

    /**
     * Actualiza un horario de juego existente con los datos proporcionados en el horario de juego.
     * Si el horario de juego no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID del horario de juego a actualizar.
     * @param horarioJuego El HorarioJuego con los nuevos datos del horario de juego.
     */
    public void update(Long id, HorarioJuego horarioJuego) {
        HorarioJuego horarioJuegoExistente = horarioJuegoRepository.findById(id).orElse(null);
        if (horarioJuegoExistente != null) {
            horarioJuegoExistente.setHoraInicio(horarioJuego.getHoraInicio());
            horarioJuegoExistente.setHoraFin(horarioJuego.getHoraFin());
            horarioJuegoRepository.save(horarioJuegoExistente);
        } else {
            throw new NoEncontradoExcepcion(" La entrada con el Id: " + id +
                " no existe");
        }
    }

    /**
     * Elimina un horario de juego por su ID.
     * Si el horario de juego no existe, se lanza una EmptyResultDataAccessException.
     * @param id El ID del horario de juego a eliminar.
     */
    public void deleteById(Long id) {
        try {
            horarioJuegoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(("Ocurrió un error al eliminar el horario del juego"));
        }
    }
}
