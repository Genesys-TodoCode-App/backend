package entradasApp.controller;

import entradasApp.entities.Comprador;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.CompradorRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private CompradorRepository compradorRepository;

    public CompradorController(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @PostMapping
    public void create(@RequestBody Comprador comprador) {
        boolean existeComprador = compradorRepository.existsById(comprador.getIdComprador());
        if (existeComprador) {
            throw new ExisteEnBaseDeDatosExcepcion("Este comprador existe en base de datos");
        }
        compradorRepository.save(comprador);
    }

    @GetMapping
    public ResponseEntity<List<Comprador>> findAll() {
        List<Comprador> listaDeCompradores = compradorRepository.findAll();
        return ResponseEntity.ok(listaDeCompradores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comprador> findById(@PathVariable Long id) {
        Comprador comprador = compradorRepository.findById(id).orElse(null);
        if (comprador !=null ) {
            return ResponseEntity.ok(comprador);
        } else {
            throw new NoEncontradoExcepcion("El comprador con el id: " + id + "no existe");
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@PathVariable Long id, @RequestBody Comprador comprador) {
        Comprador compradorexistente = compradorRepository.findById(id).orElse(null);
        if (compradorexistente != null) {
            compradorexistente.setIdComprador(comprador.getIdComprador());
            compradorexistente.setNombreComprador(comprador.getNombreComprador());
            compradorexistente.setApellidoComprador(comprador.getApellidoComprador());
            compradorexistente.setDniComprador(comprador.getDniComprador());
            compradorexistente.setCorreoElectronicoComprador(compradorexistente.getCorreoElectronicoComprador());
            compradorexistente.setPaseDeOro(comprador.isPaseDeOro());
            compradorRepository.save(compradorexistente);
            return ResponseEntity.ok(compradorexistente);
        } else {
            throw new NoEncontradoExcepcion("El comprador con el id " + id + " no ha sido encontrado");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            compradorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrio un error al eliminar el juego con el id: " + id);
        }
    }

}
