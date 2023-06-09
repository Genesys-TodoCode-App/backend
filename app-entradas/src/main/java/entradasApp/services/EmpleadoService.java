package entradasApp.services;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.mapper.GenericModelMapper;
import entradasApp.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Clase de servicio que maneja las operaciones relacionadas con los empleados.
 */
@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final GenericModelMapper mapper;
    private final ModelMapper modelMapper;

    /**
     * Constructor de la clase EmpleadoService.
     * @param modelMapper mapeador de entidades
     * @param empleadoRepository Repositorio de empleados.
     * @param mapper mapeador para DTO
     */
    public EmpleadoService(EmpleadoRepository empleadoRepository, GenericModelMapper mapper,
                           ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.mapper = mapper;

        this.modelMapper = modelMapper;
    }


    /**
     * Crea un nuevo empleado.
     * Si el empleado ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     *
     * @param empleadoDTO El empleado a crear.
     */
    public void create(EmpleadoDTO empleadoDTO) {
        Empleado empleado = mapper.reverseMaptoEmpleado(empleadoDTO);
        empleadoRepository.save(empleado);
    }


    /**
     * Obtiene todos los empleados y los devuelve como una lista de EmpleadoDTO.
     * Como se debe asignar un usuario se agrega un try-catch para evitar una PointerNullException.
     * @param pageable Paginación.
     * @return Una lista de EmpleadoDTO que representa a todos los empleados.
     */
    public Page<EmpleadoDTO> findAll(Pageable pageable) {
        Page<Empleado> empleadosPage = empleadoRepository.findAll(pageable);
        return empleadosPage.map(mapper::mapToEmpleadoDTO);
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
            EmpleadoDTO empleadoDTO = mapper.mapToEmpleadoDTO(empleado);
            if (empleado.getUsuario() != null) {
                empleadoDTO.setRolEmpleado(empleado.getUsuario().getRolEmpleado());
            }
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
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.typeMap(EmpleadoDTO.class, Empleado.class).addMappings(mapper -> {
                mapper.map(src -> src.getJuegos(), Empleado::setJuegos);
            });
            modelMapper.map(empleadoDTO, empleado);
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

