package entradasApp.controller;

import entradasApp.entities.Entrada;
import entradasApp.services.EntradaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para las operaciones relacionadas con las entradas.
 *
 * @author Gustavo
 */
@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private final EntradaService entradaService;

    /**
     * Constructor de la clase EntradaController.
     *
     * @param entradaService instancia del servicio de entradas
     */
    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    /**
     * Crea una nueva entrada.
     *
     * @param entrada objeto Entrada a crear
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Entrada entrada) {
        entradaService.create(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Obtiene todas las entradas.
     *
     * @return ResponseEntity con la lista de entradas
     */
    @GetMapping
    public ResponseEntity<List<Entrada>> findAll() {
        List<Entrada> listaDeEntradas = entradaService.findAll();
        return ResponseEntity.ok(listaDeEntradas);
    }

    /**
     * Obtiene una entrada por su ID.
     *
     * @param id ID de la entrada a buscar
     * @return ResponseEntity con la entrada encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Entrada> findById(@PathVariable Long id) {
        Entrada entrada = entradaService.findById(id);
        return ResponseEntity.ok(entrada);
    }

    /**
     * Actualiza una entrada existente.
     *
     * @param id      ID de la entrada a actualizar
     * @param entrada objeto Entrada con los datos actualizados
     * @return ResponseEntity con la entrada actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@Valid @PathVariable Long id, @RequestBody Entrada entrada) {
        Entrada entradaExistente = entradaService.findById(id);
        return ResponseEntity.ok(entradaExistente);
    }

    /**
     * Elimina una entrada por su ID.
     *
     * @param id ID de la entrada a eliminar
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        entradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
