package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
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

    @PostMapping
    public void create(@RequestBody Empleado empleado) {
        boolean existeEmpleado = empleadoRepository.existsById(empleado.getIdEmpleado());
        if (existeEmpleado) {
            throw new ExisteEnBaseDeDatosExcepcion("Existe este empleado en base de datos");
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
            throw  new NoEncontradoExcepcion("Empleado con el ID " + id + " no encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            empleado.setUsuarioEmpleado(empleadoDTO.getUsuarioEmpleado());
            empleado.setContraseniaEmpleado(empleadoDTO.getContraseniaEmpleado());
            empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
            empleado.setApellidoEmpleado(empleado.getApellidoEmpleado());
            empleado.setDniEmpleado(empleado.getApellidoEmpleado());
            empleado.setRutaALaFoto(empleado.getRutaALaFoto());
            empleado.setRolEmpleado(empleado.getRolEmpleado());

            empleadoRepository.save(empleado);

            EmpleadoDTO empleadoActualizadoDTO = convertToDTO(empleado);
            return  ResponseEntity.ok(empleadoActualizadoDTO);
        } else {
            throw  new NoEncontradoExcepcion("Empleado con el Id: " + " no encontrado");
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


}
