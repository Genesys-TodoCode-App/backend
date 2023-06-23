package entradasApp.services;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.dtos.JuegoDTO;
import entradasApp.entities.Empleado;
import entradasApp.entities.Juego;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void create(Empleado empleado) {
        boolean existeEmpleado = empleadoRepository.existsById(empleado.getIdEmpleado());
        if (existeEmpleado) {
            throw new ExisteEnBaseDeDatosExcepcion("Existe este empleado en la base de datos");
        }
        empleadoRepository.save(empleado);
    }

    public Iterable<EmpleadoDTO> findAll() {
        Iterable<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            EmpleadoDTO empleadoDTO = mapEmpleadoToDTO(empleado);
            empleadosDTO.add(empleadoDTO);
        }
        return empleadosDTO;
    }

    public EmpleadoDTO findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            EmpleadoDTO empleadoDTO = mapEmpleadoToDTO(empleado);
            return empleadoDTO;
        } else {
            throw new NoEncontradoExcepcion("El empleado con el id: " + id + " no ha sido encontrado");
        }
    }

    public void update(Long id, EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
            empleado.setApellidoEmpleado(empleadoDTO.getApellidoEmpleado());
            empleado.setDniEmpleado(empleadoDTO.getDniEmpleado());
            empleado.setRutaALaFoto(empleadoDTO.getRutaALaFoto());
            empleadoRepository.save(empleado);
        } else {
            throw new NoEncontradoExcepcion("Empleado con el Id: " + id + " no encontrado");
        }
    }

    public void deleteById(Long id) {
        try {
            empleadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el Empleado");
        }
    }

    // Mapeador para convertir Empleado a EmpleadoDTO
    private EmpleadoDTO mapEmpleadoToDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
        empleadoDTO.setNombreEmpleado(empleado.getNombreEmpleado());
        empleadoDTO.setApellidoEmpleado(empleado.getApellidoEmpleado());
        empleadoDTO.setDniEmpleado(empleado.getDniEmpleado());
        empleadoDTO.setRutaALaFoto(empleado.getRutaALaFoto());
        empleadoDTO.setRolEmpleado(empleado.getUsuario().getRolEmpleado());
        empleadoDTO.setJuegos(mapJuegosToDTO(empleado.getJuegos()));
        return empleadoDTO;
    }

    // Mapeador para convertir lista de Juego a lista de JuegoDTO
    private List<JuegoDTO> mapJuegosToDTO(List<Juego> juegos) {
        List<JuegoDTO> juegosDTO = new ArrayList<>();
        if (juegos != null) {
            for (Juego juego : juegos) {
                JuegoDTO juegoDTO = new JuegoDTO();
                juegoDTO.setIdJuego(juego.getIdJuego());
                juegoDTO.setNombreJuego(juego.getNombreJuego());
                juegosDTO.add(juegoDTO);
            }
        }
        return juegosDTO;
    }
}


