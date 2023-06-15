package entradasApp.controller;

import entradasApp.entities.VentaEntrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.VentaEntradaRepository;
import jakarta.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventaentradas")
public class VentaEntradaController {

    private VentaEntradaRepository ventaEntradaRepository;

    public VentaEntradaController(VentaEntradaRepository ventaEntradaRepository) {
        this.ventaEntradaRepository = ventaEntradaRepository;
    }

    @PostMapping
    public void create(@Valid @RequestBody VentaEntrada ventaEntrada) {
        boolean existeVentaEntrada = ventaEntradaRepository.existsById(ventaEntrada.getIdVentaEntrada());
        if (existeVentaEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta venta de entradas en base de datos");
        }
    }

    @GetMapping
    public ResponseEntity<List<VentaEntrada>> findAll() {
        List<VentaEntrada> listaVentaEntradas = ventaEntradaRepository.findAll();
        return ResponseEntity.ok(listaVentaEntradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaEntrada> findById(@PathVariable Long id) {
        VentaEntrada ventaEntrada = ventaEntradaRepository.findById(id).orElse(null);
        if (ventaEntrada != null) {
            return ResponseEntity.ok(ventaEntrada);
        } else {
            throw new NoEncontradoExcepcion(" La venta de entrada con el id: " + id + " no ha sido encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaEntrada> update(@Valid @PathVariable Long id, @RequestBody VentaEntrada ventaEntrada) {
        VentaEntrada ventaEntradaExistente = ventaEntradaRepository.findById(id).orElse(null);
        if (ventaEntradaExistente != null) {
            ventaEntradaExistente.setIdVentaEntrada(ventaEntrada.getIdVentaEntrada());
            ventaEntradaExistente.setEntrada(ventaEntrada.getEntrada());
            ventaEntradaExistente.setMontoVenta(ventaEntrada.getMontoVenta());
            ventaEntradaExistente.setFechaVenta(ventaEntrada.getFechaVenta());
            ventaEntradaRepository.save(ventaEntradaExistente);
            return ResponseEntity.ok(ventaEntradaExistente);
        } else {
            throw new NoEncontradoExcepcion(" La venta de entradas con el id: " + id + "no ha sido encontrada");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            ventaEntradaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la venta de entradas con el id: " + id);
        }
    }

}
