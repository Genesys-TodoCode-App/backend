package entradasApp.controller;

import entradasApp.entities.Comprador;
import entradasApp.services.CompradorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Comprador comprador) {
        compradorService.createComprador(comprador);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Comprador>> findAll() {
        Iterable<Comprador> listaDeCompradores = compradorService.findAll();
        return ResponseEntity.ok(listaDeCompradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comprador> findById(@PathVariable Long id) {
        Comprador comprador = compradorService.findById(id);
        return ResponseEntity.ok(comprador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@Valid @PathVariable Long id, @RequestBody Comprador comprador) {
        Comprador compradorexistente = compradorService.findById(id);
        return ResponseEntity.ok(compradorexistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        compradorService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
