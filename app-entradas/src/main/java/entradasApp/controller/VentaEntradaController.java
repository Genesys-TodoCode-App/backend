package entradasApp.controller;

import entradasApp.entities.VentaEntrada;
import entradasApp.services.VentaEntradaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador para las operaciones CRUD relacionadas con las ventas de entradas.
 * Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre las ventas de entradas.
 * Las ventas de entradas son objetos de la clase VentaEntrada.
 * Este controlador está mapeado a la ruta "/ventas-entradas".
 */

@RestController
@RequestMapping("/ventas-entradas")
public class VentaEntradaController {


    private final VentaEntradaService ventaEntradaService;

    /**
     * Constructor de la clase VentaEntradaController.
     * @param ventaEntradaService
     */
    @Autowired
    public VentaEntradaController(VentaEntradaService ventaEntradaService) {
        this.ventaEntradaService = ventaEntradaService;
    }

    /**
     * Método para crear una nueva venta de entrada.
     * Recibe un objeto VentaEntrada en el cuerpo de la solicitud.
     *
     * @param ventaEntrada El objeto VentaEntrada que se va a crear.
     */
    @PostMapping
    public void create(@Valid @RequestBody VentaEntrada ventaEntrada) {
        ventaEntradaService.create(ventaEntrada);
    }
    /**
     * Método para obtener todas las ventas de entradas.
     *
     * @return ResponseEntity con una lista Iterable de VentaEntrada en el cuerpo de la respuesta.
     */
    @GetMapping
    public ResponseEntity<Iterable<VentaEntrada>> findAll() {
        Iterable<VentaEntrada> listaVentaEntradas = ventaEntradaService.findAll();
        return ResponseEntity.ok(listaVentaEntradas);
    }
    /**
     * Método para buscar una venta de entrada por su ID.
     *
     * @param id El ID de la venta de entrada a buscar.
     * @return ResponseEntity con el objeto VentaEntrada encontrado en el cuerpo de la respuesta.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VentaEntrada> findById(@PathVariable Long id) {
        VentaEntrada ventaEntrada = ventaEntradaService.findById(id);
        return ResponseEntity.ok(ventaEntrada);
    }

    /**
     * Método para actualizar una venta de entrada existente.
     * Recibe el ID de la venta de entrada a actualizar y un objeto VentaEntrada en el cuerpo de la solicitud.
     *
     * @param id            El ID de la venta de entrada a actualizar.
     * @param ventaEntrada  El objeto VentaEntrada con los nuevos datos.
     * @return ResponseEntity con el objeto VentaEntrada actualizada en el cuerpo de la respuesta.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VentaEntrada> update(@Valid @PathVariable Long id, @RequestBody VentaEntrada ventaEntrada) {
        VentaEntrada ventaEntradaActualizada = ventaEntradaService.update(id, ventaEntrada);
        return ResponseEntity.ok(ventaEntradaActualizada);
    }

    /**
     * Método para eliminar una venta de entrada por su ID.
     *
     * @param id El ID de la venta de entrada a eliminar.
     * @return ResponseEntity con estado HTTP 204 (NO_CONTENT) si se elimina la venta de entrada correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ventaEntradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
