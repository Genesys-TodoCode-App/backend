package entradasApp.controller;

import entradasApp.entities.VentaEntrada;
import entradasApp.services.VentaEntradaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ventas-entradas")
public class VentaEntradaController {

    private final VentaEntradaService ventaEntradaService;

    public VentaEntradaController(VentaEntradaService ventaEntradaService) {
        this.ventaEntradaService = ventaEntradaService;
    }

    @PostMapping
    public void create(@Valid @RequestBody VentaEntrada ventaEntrada) {
        ventaEntradaService.create(ventaEntrada);
    }

    @GetMapping
    public ResponseEntity<List<VentaEntrada>> findAll() {
        List<VentaEntrada> listaVentaEntradas = ventaEntradaService.findAll();
        return ResponseEntity.ok(listaVentaEntradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaEntrada> findById(@PathVariable Long id) {
        VentaEntrada ventaEntrada = ventaEntradaService.findById(id);
        return ResponseEntity.ok(ventaEntrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaEntrada> update(@Valid @PathVariable Long id, @RequestBody VentaEntrada ventaEntrada) {
        VentaEntrada ventaEntradaActualizada = ventaEntradaService.update(id, ventaEntrada);
        return ResponseEntity.ok(ventaEntradaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ventaEntradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
