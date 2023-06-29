package entradasApp.controller;

import entradasApp.dtos.EntradaDTO;
import entradasApp.entities.Entrada;
import entradasApp.services.EntradaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para las operaciones CRUD relacionadas con las entradas.
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
    public ResponseEntity<Void> create(@Valid @RequestBody EntradaDTO entrada) {
        entradaService.create(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * Obtiene todas las entradas.
     * Incluye una paginación para 20 entradas por página.
     * @param page la página a obtener
     * @param size el número de entradas por página
     * @return ResponseEntity con las entradas encontradas
     */
    @GetMapping
    public ResponseEntity<Page<EntradaDTO>> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<EntradaDTO> entradas = entradaService.findAll(pageable);
        return ResponseEntity.ok(entradas);
    }


    /**
     * Obtiene una entrada por su ID.     *
     * @param id ID de la entrada a buscar
     * @return ResponseEntity con la entrada encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<EntradaDTO> findById(@PathVariable Long id) {
        EntradaDTO entrada = entradaService.findById(id);
        return ResponseEntity.ok(entrada);
    }


    /**
     * Actualiza una entrada existente.     *
     * @param id      ID de la entrada a actualizar
     * @param entrada objeto Entrada con los datos actualizados
     * @return ResponseEntity con la entrada actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<EntradaDTO> update(@Valid @PathVariable Long id, @RequestBody Entrada entrada) {
        EntradaDTO entradaExistente = entradaService.findById(id);
        return ResponseEntity.ok(entradaExistente);
    }


    /**
     * Elimina una entrada por su ID.
     * @param id ID de la entrada a eliminar
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        entradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
