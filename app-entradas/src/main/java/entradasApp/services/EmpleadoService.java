package entradasApp.services;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
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

    public void create(Empleado empleado){
        boolean existeEmpleado = empleadoRepository.existsById(empleado.getIdEmpleado());
        if (existeEmpleado) {
            throw new ExisteEnBaseDeDatosExcepcion("Existe este empleado en base de datos");
        }
        empleadoRepository.save(empleado);
    }
    public List<EmpleadoDTO> findAll(){
        List<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
           EmpleadoDTO empleadoDTO = convertToDTO(empleado);
           empleadosDTO.add(empleadoDTO);
        }
        return empleadosDTO;
    }
    public EmpleadoDTO findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado != null) {
            return convertToDTO(empleado);
        } else {
            throw  new NoEncontradoExcepcion("El empleado con el id: " + id + " no ha sido encontrado");
        }
    }
    public void update(Long id, EmpleadoDTO empleadoDTO){
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
        } else {
            throw  new NoEncontradoExcepcion("Empleado con el Id: " + " no encontrado");
        }
    }
    public  void  deleteById(Long id){
        try {
            empleadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw  new RuntimeException("Ocurrió un error al eliminar el Empleado");
        }
    }

}
