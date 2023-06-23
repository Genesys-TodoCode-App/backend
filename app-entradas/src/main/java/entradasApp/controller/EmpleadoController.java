package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para las operaciones relacionadas con los empleados.
 * Por cuestiones de seguridad, no se permite borrar a todos los empleados.
 * @author Gustavo
 */
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private final EmpleadoService empleadoService;
    /**
     * Constructor de la clase EmpleadoController.
     *
     * @param empleadoService instancia del servicio de empleados
     */
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    /**
     * Crea un nuevo empleado.
     *
     * @param empleado objeto Empleado a crear
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Empleado empleado) {
        empleadoService.create(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * Obtiene todos los empleados.
     *
     * @return ResponseEntity con la lista de empleados
     */
    @GetMapping
    public ResponseEntity<Iterable<EmpleadoDTO>> findAll() {
        Iterable<EmpleadoDTO> empleadoDTO = empleadoService.findAll();
        return ResponseEntity.ok(empleadoDTO);
    }


    /**
     * Obtiene un empleado por su ID.
     *
     * @param id ID del empleado a buscar
     * @return ResponseEntity con el empleado encontrado
     */

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Long id) {
        EmpleadoDTO empleadoDTO = empleadoService.findById(id);
        return ResponseEntity.ok(empleadoDTO);
    }



    /**
     * Actualiza un empleado existente.
     *
     * @param id           ID del empleado a actualizar
     * @param empleadoDTO objeto EmpleadoDTO con los datos actualizados
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@Valid @PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        empleadoService.update(id, empleadoDTO);
        return ResponseEntity.ok().build();
    }


    /**
     * Elimina un empleado por su ID.
     *
     * @param id ID del empleado a eliminar
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
