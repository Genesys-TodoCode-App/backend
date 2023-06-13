package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.EmpleadoExistenteExcepcion;
import entradasApp.exceptions.EmpleadoNoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @PostMapping
    public void create(@RequestBody Empleado empleado) {
        boolean existeEmpleado = empleadoRepository.existsById(empleado.getIdEmpleado());
        if (existeEmpleado) {
            throw new EmpleadoExistenteExcepcion(empleado.getIdEmpleado());
        }
        empleadoRepository.save(empleado);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll(){
        List<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            EmpleadoDTO empleadoDTO = convertToDTO(empleado);
            empleadosDTO.add(empleadoDTO);
        }
        return ResponseEntity.ok(empleadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Long id){
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado != null){
            EmpleadoDTO empleadoDTO = convertToDTO(empleado);
            return ResponseEntity.ok(empleadoDTO);
        } else {
            throw  new EmpleadoNoEncontradoExcepcion("Empleado con el ID " + id + " no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            empleadoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el empleado con ID: " + id);
        }
    }

    private EmpleadoDTO convertToDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setUsuarioEmpleado(empleado.getUsuarioEmpleado());
        empleadoDTO.setContraseniaEmpleado(empleado.getContraseniaEmpleado());
        empleadoDTO.setNombreEmpleado(empleado.getNombreEmpleado());
        empleadoDTO.setApellidoEmpleado(empleado.getApellidoEmpleado());
        empleadoDTO.setDniEmpleado(empleado.getApellidoEmpleado());
        empleadoDTO.setRutaALaFoto(empleado.getRutaALaFoto());
        empleadoDTO.setRolEmpleado(empleado.getRolEmpleado());
        return empleadoDTO;
    }
}
