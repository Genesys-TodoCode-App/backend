package entradasApp.controller;

import entradasApp.entities.HorarioJuego;
import entradasApp.services.HorarioJuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para las operaciones relacionadas con el horario de los juegos('horario juego de aquí en más')
 * Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los horarios de juego.
 * Los horarios de juego son objetos de la clase HorarioJuego.
 * Este controlador utiliza la clase HorarioJuegoService para acceder a la lógica de negocio relacionada con los horarios de juego.
 * El controlador está mapeado a la ruta "/horariojuego".
 * @author Gustavo
 */
@RestController
@RequestMapping("/horariojuego")
public class HorarioJuegoController {

    @Autowired
    private final HorarioJuegoService horarioJuegoService;


    /**
     * Constructor de la clase HorarioJuegoController.
     *
     * @param horarioJuegoService El servicio de HorarioJuego que se utilizará en el controlador.
     */
    public HorarioJuegoController(HorarioJuegoService horarioJuegoService) {
        this.horarioJuegoService = horarioJuegoService;
    }

    /**
     * Método para crear un nuevo horario de juego.
     * Recibe un objeto HorarioJuego en el cuerpo de la solicitud.
     *
     * @param horarioJuego El objeto HorarioJuego que se va a crear.
     * @return ResponseEntity con estado HTTP 201 (CREATED) si se crea el horario de juego correctamente.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody HorarioJuego horarioJuego) {
        horarioJuegoService.create(horarioJuego);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Método para obtener todos los horarios de juego.
     *
     * @return ResponseEntity con una lista Iterable de HorarioJuego en el cuerpo de la respuesta.
     */
    @GetMapping
    public ResponseEntity<Iterable<HorarioJuego>> findAll() {
        Iterable<HorarioJuego> listaHorarioJuegos = horarioJuegoService.findAll();
        return ResponseEntity.ok(listaHorarioJuegos);

    }
    /**
     * Método para buscar un horario de juego por su ID.
     *
     * @param id El ID del horario de juego a buscar.
     * @return ResponseEntity con el objeto HorarioJuego encontrado en el cuerpo de la respuesta.
     */
    @PutMapping("/{id}")
    public ResponseEntity<HorarioJuego> findById(@PathVariable Long id) {
        HorarioJuego horarioJuego = horarioJuegoService.findById(id);
        return ResponseEntity.ok(horarioJuego);

    }
    /**
     * Método para eliminar un horario de juego por su ID.
     *
     * @param id El ID del horario de juego a eliminar.
     * @return ResponseEntity con estado HTTP 204 (NO_CONTENT) si se elimina el horario de juego correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        horarioJuegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
