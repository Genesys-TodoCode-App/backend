package entradasApp.controller;

import entradasApp.entities.Juego;
import entradasApp.services.JuegoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    private JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Juego juego) {
        juegoService.create(juego);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<Iterable<Juego>> findAll() {
        Iterable<Juego> listaDeJuegos = juegoService.findAll();
        return ResponseEntity.ok(listaDeJuegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> findById(@PathVariable Long id) {
        Juego juego = juegoService.findById(id);
        return ResponseEntity.ok(juego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juego> update(@Valid @PathVariable Long id, @RequestBody Juego juego) {
      Juego juegoExistente = juegoService.findById(id);
      return ResponseEntity.ok(juegoExistente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        juegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
