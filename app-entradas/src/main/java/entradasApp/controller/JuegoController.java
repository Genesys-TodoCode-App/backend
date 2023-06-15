package entradasApp.controller;

import entradasApp.entities.Juego;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.JuegoRepository;
import jakarta.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    private JuegoRepository juegoRepository;

    public JuegoController(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @PostMapping
    public void create(@Valid @RequestBody Juego juego) {
        boolean existeJuego = juegoRepository.existsById(juego.getIdJuego());
        if (existeJuego) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe en base de datos este juego");
        }
    }
    @GetMapping
    public ResponseEntity<List<Juego>> findAll() {
        List<Juego> listaDeJuegos = juegoRepository.findAll();
        return ResponseEntity.ok(listaDeJuegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> findById(@PathVariable Long id) {
        Juego juego = juegoRepository.findById(id).orElse(null);
        if (juego != null) {
            return ResponseEntity.ok(juego);
        } else {
            throw new NoEncontradoExcepcion("Juego con el id:" + id + "no encontradp.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juego> update(@Valid @PathVariable Long id, @RequestBody Juego juego) {
        Juego juegoExistente = juegoRepository.findById(id).orElse(null);
        if (juegoExistente != null) {
            juegoExistente.setNombreJuego(juego.getNombreJuego());
            juegoExistente.setPrecioJuego(juego.getPrecioJuego());
            juegoExistente.setHoraInicio(juego.getHoraInicio());
            juegoExistente.setHoraFin((juego.getHoraFin()));
            juegoExistente.setEmpleadoAutorizado(juego.getEmpleadoAutorizado());
            juegoRepository.save(juegoExistente);
            return ResponseEntity.ok(juegoExistente);
        } else {
            throw new NoEncontradoExcepcion("El juego con el id: " + id + " no ha sido encontrado");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            juegoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrio un error al eliminar el juego con el id: " + id);
        }
    }
}
