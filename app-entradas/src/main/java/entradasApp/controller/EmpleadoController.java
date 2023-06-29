package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.services.EmpleadoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final ModelMapper modelMapper;


    /**
     * Constructor de la clase EmpleadoController.
     *
     * @param empleadoService instancia del servicio de empleados
     * @param modelMapper  instancia del modelo mapper
     */
    public EmpleadoController(EmpleadoService empleadoService, ModelMapper modelMapper) {
        this.empleadoService = empleadoService;
        this.modelMapper = modelMapper;
    }


    /**
     * Crea un empleado.
     * @param empleadoDTO objeto EmpleadoDTO con los datos del empleado a crear
     * @return ResponseEntity con el estado HTTP de la respuesta
     */
    @PostMapping(value = "/", consumes = {"application/json","application/xml"})
    public ResponseEntity<Void> create(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
        empleadoService.create(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * Obtiene todos los empleados.
     * @param page pagina de la consulta
     * @param size cantidad de registros por pagina
     * @return ResponseEntity con la lista de empleados
     */
    @GetMapping
    public ResponseEntity<Page<EmpleadoDTO>> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<EmpleadoDTO> empleadoDTOPage = empleadoService.findAll(pageable);
        return ResponseEntity.ok(empleadoDTOPage);
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
