package entradasApp.controller;

import entradasApp.entities.Entrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EntradaRepository;
import entradasApp.services.EntradaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Entrada entrada) {
        entradaService.create(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Entrada>> findAll(){
        List<Entrada> listaDeEntradas = entradaService.findAll();
        return ResponseEntity.ok(listaDeEntradas);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Entrada> findById(@PathVariable Long id) {
       Entrada entrada = entradaService.findById(id);
       return ResponseEntity.ok(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@Valid @PathVariable Long id, @RequestBody Entrada entrada) {
        Entrada entradaExistente = entradaService.findById(id);
        return ResponseEntity.ok(entradaExistente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
      entradaService.deleteById(id);
      return ResponseEntity.noContent().build();
    }

}
