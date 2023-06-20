package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Empleado empleado) {
        empleadoService.create(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<EmpleadoDTO>> findAll(){
        Iterable<EmpleadoDTO> empleadoDTO = empleadoService.findAll();
        return ResponseEntity.ok(empleadoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Long id){
       EmpleadoDTO empleadoDTO = empleadoService.findById(id);
       return ResponseEntity.ok(empleadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@Valid @PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
       empleadoService.update(id, empleadoDTO);
       return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
     empleadoService.deleteById(id);
     return ResponseEntity.noContent().build();
    }


}
