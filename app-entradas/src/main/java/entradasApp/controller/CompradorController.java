package entradasApp.controller;

import entradasApp.entities.Comprador;
import entradasApp.services.CompradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador para manejar las operaciones relacionadas con los compradores.
 * @author  Gustavo
 */
@RestController
@RequestMapping("/compradores")
public class CompradorController {

    @Autowired
    private final CompradorService compradorService;

    /**
     * Constructor de la clase
     * @param compradorService
     */
    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    /**
     * Crea un nuevo comprador.
     *
     * @param comprador El objeto Comprador a crear.
     * @return ResponseEntity con el estado HTTP 201 (Created) si el comprador se crea correctamente.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Comprador comprador) {
        compradorService.createComprador(comprador);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Obtiene todos los compradores.
     *
     * @return ResponseEntity con el estado HTTP 200 (OK) y la lista de compradores si se encuentran compradores.
     */
    @GetMapping
    public ResponseEntity<Iterable<Comprador>> findAll() {
        Iterable<Comprador> listaDeCompradores = compradorService.findAll();
        return ResponseEntity.ok(listaDeCompradores);
    }

    /**
     * Obtiene un comprador por su ID.
     *
     * @param id El ID del comprador a buscar.
     * @return ResponseEntity con el estado HTTP 200 (OK) y el comprador si se encuentra, o el estado HTTP 404 (Not Found) si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Comprador> findById(@PathVariable Long id) {
        Comprador comprador = compradorService.findById(id);
        return ResponseEntity.ok(comprador);
    }

    /**
     * Actualiza un comprador existente.
     *
     * @param id        El ID del comprador a actualizar.
     * @param comprador El objeto Comprador con los nuevos datos.
     * @return ResponseEntity con el estado HTTP 200 (OK) y el comprador actualizado si se encuentra, o el estado HTTP 404 (Not Found) si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@Valid @PathVariable Long id, @RequestBody Comprador comprador) {
        Comprador compradorexistente = compradorService.findById(id);
        return ResponseEntity.ok(compradorexistente);
    }

    /**
     * Elimina un comprador por su ID.
     *
     * @param id El ID del comprador a eliminar.
     * @return ResponseEntity con el estado HTTP 204 (No Content) si el comprador se elimina correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        compradorService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
