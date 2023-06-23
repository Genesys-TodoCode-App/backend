package entradasApp.services;

import entradasApp.entities.HorarioJuego;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.HorarioJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioJuegoService {

    @Autowired
    private final HorarioJuegoRepository horarioJuegoRepository;

    public HorarioJuegoService(HorarioJuegoRepository horarioJuegoRepository) {
        this.horarioJuegoRepository = horarioJuegoRepository;
    }

    public void create(HorarioJuego horarioJuego) {
        boolean existeHorarioJuego = horarioJuegoRepository.existsById(horarioJuego.getIdHorarioJuego());
    }

    public Iterable<HorarioJuego> findAll() {
        return horarioJuegoRepository.findAll();
    }

    public HorarioJuego findById(Long id) {
        return horarioJuegoRepository.findById(id).orElse(null);
    }

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

    public void deleteById(Long id) {
        try {
            horarioJuegoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(("Ocurrió un error al eliminar el horario del juego"));
        }
    }
}
