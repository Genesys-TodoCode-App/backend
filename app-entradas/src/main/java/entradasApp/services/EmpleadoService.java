package entradasApp.services;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    /**
     * Constructor de la clase EmpleadoService.
     *
     * @param empleadoRepository Repositorio de empleados.
     * @param modelMapper        Mapper de entidades a DTOs.
     */
    public EmpleadoService(EmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }


    /**
     * Crea un nuevo empleado.
     * Si el empleado ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     *
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
     * Como se debe asignar un usuario se agrega un try-catch para evitar una PointerNullException.
     * @return Una lista de EmpleadoDTO que representa a todos los empleados.
     */
    public Iterable<EmpleadoDTO> findAll() {
        Iterable<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
            try {
                empleadoDTO.setRolEmpleado(empleado.getUsuario().getRolEmpleado());
                empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
                empleadoDTO.setJuegosAsignados(empleado.getJuegos());
            } catch (NullPointerException e) {
                empleadoDTO.setRolEmpleado(null);
            }
            empleadosDTO.add(empleadoDTO);
        }
        return empleadosDTO;
    }



    /**
     * Busca un empleado por su ID y lo devuelve como un EmpleadoDTO.
     * Si el empleado no existe, se lanza una NoEncontradoExcepcion.
     *
     * @param id El ID del empleado a buscar.
     * @return El EmpleadoDTO correspondiente al empleado encontrado.
     */
    public EmpleadoDTO findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
            empleadoDTO.setRolEmpleado(empleado.getUsuario().getRolEmpleado());// a ver si se agrega el rol
            return empleadoDTO;
        } else {
            throw new NoEncontradoExcepcion("El empleado con el id: " + id + " no ha sido encontrado");
        }
    }


    /**
     * Actualiza un empleado existente con los datos proporcionados en el EmpleadoDTO.
     * Si el empleado no existe, se lanza una NoEncontradoExcepcion.
     *
     * @param id          El ID del empleado a actualizar.
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
     *
     * @param id El ID del empleado a eliminar.
     */
    public void deleteById(Long id) {
        try {
            empleadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el Empleado");
        }
    }
}

