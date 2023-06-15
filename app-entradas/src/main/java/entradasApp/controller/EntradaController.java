package entradasApp.controller;

import entradasApp.entities.Entrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EntradaRepository;
import jakarta.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    private EntradaRepository entradaRepository;

    public EntradaController(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }
    @PostMapping
    public void create(@Valid @RequestBody Entrada entrada) {
        boolean existeEntrada = entradaRepository.existsById(entrada.getIdEntrada());
        if (existeEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta entrada en la base de datos");
        }
    }
    @GetMapping
    public ResponseEntity<List<Entrada>> findAll(){
        List<Entrada> listaDeEntradas = entradaRepository.findAll();
        return ResponseEntity.ok(listaDeEntradas);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Entrada> findById(@PathVariable Long id) {
        Entrada entrada = entradaRepository.findById(id).orElse(null);
        if (entrada != null) {
            return ResponseEntity.ok(entrada);
        } else {
            throw new NoEncontradoExcepcion("Entrada con el id: " + "no encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@Valid @PathVariable Long id, @RequestBody Entrada entrada) {
        Entrada entradaExistente = entradaRepository.findById(id).orElse(null);
        if (entradaExistente != null) {
            entradaExistente.setFechaHoraUtilizacion(entrada.getFechaHoraUtilizacion());
            entradaExistente.setJuego(entrada.getJuego());
            entradaExistente.setComprador(entrada.getComprador());
            entradaExistente.setEmpleadoVendedor(entrada.getEmpleadoVendedor());
            entradaRepository.save(entradaExistente);

            return ResponseEntity.ok(entradaExistente);
        } else {
            throw  new NoEncontradoExcepcion("La entrada con el Id: " + id + " no ha sido encontrada");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            entradaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la entrada con el id: " + id);
        }
    }

}
