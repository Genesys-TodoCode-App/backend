package entradasApp.controller;

import entradasApp.entities.Juego;
import entradasApp.services.JuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador para las operaciones CRUD relacionadas con los juegos.
 * Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los juegos.
 * Los juegos son objetos de la clase Juego.
 * Este controlador está mapeado a la ruta "/juegos".
 */
@RestController
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    private final JuegoService juegoService;

    /**
     * Constructor de la clase JuegoController.
     *
     * @param juegoService El servicio de JuegoService que se utilizará en el controlador.
     */
    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    /**
     * Método para crear un nuevo juego.
     * Recibe un objeto Juego en el cuerpo de la solicitud.
     *
     * @param juego El objeto Juego que se va a crear.
     * @return ResponseEntity con estado HTTP 201 (CREATED) si se crea el juego correctamente.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Juego juego) {
        juegoService.create(juego);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Método para obtener todos los juegos.
     *
     * @return ResponseEntity con una lista Iterable de Juego en el cuerpo de la respuesta.
     */
    @GetMapping
    public ResponseEntity<Iterable<Juego>> findAll() {
        Iterable<Juego> listaDeJuegos = juegoService.findAll();
        return ResponseEntity.ok(listaDeJuegos);
    }

    /**
     * Método para buscar un juego por su ID.
     *
     * @param id El ID del juego a buscar.
     * @return ResponseEntity con el objeto Juego encontrado en el cuerpo de la respuesta.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Juego> findById(@PathVariable Long id) {
        Juego juego = juegoService.findById(id);
        return ResponseEntity.ok(juego);
    }


    /**
     * Método para actualizar un juego existente.
     * Recibe el ID del juego a actualizar y un objeto Juego en el cuerpo de la solicitud.
     *
     * @param id    El ID del juego a actualizar.
     * @param juego El objeto Juego con los nuevos datos.
     * @return ResponseEntity con el objeto Juego existente en el cuerpo de la respuesta.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Juego> update(@Valid @PathVariable Long id, @RequestBody Juego juego) {
        Juego juegoExistente = juegoService.findById(id);
        juegoService.update(id, juego);
        return ResponseEntity.ok(juegoExistente);

    }

    /**
     * Método para eliminar un juego por su ID.
     *
     * @param id El ID del juego a eliminar.
     * @return ResponseEntity con estado HTTP 204 (NO_CONTENT) si se elimina el juego correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        juegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
