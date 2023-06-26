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

/**
 * Clase de servicio que maneja las operaciones relacionadas con los empleados.
 */
@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    /**
     * Constructor de la clase EmpleadoService.
     * @param empleadoRepository Repositorio de empleados.
     */
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }


    /**
     * Crea un nuevo empleado.
     * Si el empleado ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     * @param empleado El empleado a crear.
     */
    public void create(Empleado empleado) {
        boolean existeEmpleado = empleadoRepository.existsById(empleado.getIdEmpleado());
        if (existeEmpleado) {
            throw new ExisteEnBaseDeDatosExcepcion("Existe este empleado en la base de datos");
        }
        empleadoRepository.save(empleado);
    }


    /**
     * Obtiene todos los empleados y los devuelve como una lista de EmpleadoDTO.
     * @return Una lista de EmpleadoDTO que representa a todos los empleados.
     */
    public Iterable<EmpleadoDTO> findAll() {
        Iterable<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            EmpleadoDTO empleadoDTO = mapEmpleadoToDTO(empleado);
            empleadosDTO.add(empleadoDTO);
        }
        return empleadosDTO;
    }


    /**
     * Busca un empleado por su ID y lo devuelve como un EmpleadoDTO.
     * Si el empleado no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID del empleado a buscar.
     * @return El EmpleadoDTO correspondiente al empleado encontrado.
     */
    public EmpleadoDTO findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            EmpleadoDTO empleadoDTO = mapEmpleadoToDTO(empleado);
            return empleadoDTO;
        } else {
            throw new NoEncontradoExcepcion("El empleado con el id: " + id + " no ha sido encontrado");
        }
    }


    /**
     * Actualiza un empleado existente con los datos proporcionados en el EmpleadoDTO.
     * Si el empleado no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID del empleado a actualizar.
     * @param empleadoDTO El EmpleadoDTO con los nuevos datos del empleado.
     */
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


    /**
     * Elimina un empleado por su ID.
     * Si el empleado no existe, se lanza una EmptyResultDataAccessException.
     * @param id El ID del empleado a eliminar.
     */
    public void deleteById(Long id) {
        try {
            empleadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el Empleado");
        }
    }


    /**
     * Mapea un empleado a un EmpleadoDTO.
     * @param empleado
     * @return
     */
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


    /**
     * Mapea para convertir la lista de juegos a Lista de JuegoDTO.
     * @param juegos
     * @return
     */
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


