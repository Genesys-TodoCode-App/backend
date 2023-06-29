package entradasApp.mapper;


import entradasApp.dtos.*;
import entradasApp.entities.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza el mapeo entre las entidades y los DTOs usando ModelMapper
 */
@Component
public class GenericModelMapper {
    
    private final ModelMapper mapper = new ModelMapper();
    
    private static  GenericModelMapper instance;    

    private GenericModelMapper() {
    }

    /**
     * Constructor de la clase que inicializa el mapeo entre las entidades y los DTOs
     * @return
     */
    public static GenericModelMapper singleInstance(){
        if (instance == null){
            instance = new GenericModelMapper();
        }
        return instance;
    }

    /**
     * Método que realiza el mapeo entre la entidad Usuario y su UsuarioDTO
     * @param usuario usuario que se quiere mapear
     * @return usuarioDTO con los datos del usuario
     */
    public UsuarioLoginDTO mapToUsuarioLoginDTO(Usuario usuario){
        return mapper.map(usuario, UsuarioLoginDTO.class);}


    /**
     * Método que realiza el mapeo entre la entidad Comprador y CompradorDTO
     * @param comprador comprador que se quiere mapear
     * @return compradorDTO con los datos del comprador
     */
    public CompradorDTO mapToCompradorDTO(Comprador comprador){
        return mapper.map(comprador, CompradorDTO.class);
    }


    /**
     * Método que realiza el mapeo entre la entidad Empleado y EmpleadoDTO
     * @param empleado empleado que se quiere mapear
     * @return empleadoDTO con los datos del empleado
     */
    public EmpleadoDTO mapToEmpleadoDTO(Empleado empleado) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.addMappings(new PropertyMap<Empleado, EmpleadoDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getIdEmpleado());
                map().setNombreEmpleado(source.getNombreEmpleado());
                map().setApellidoEmpleado(source.getApellidoEmpleado());
                map().setDniEmpleado(source.getDniEmpleado());
                map().setRutaALaFoto(source.getRutaALaFoto());
                map().setRolEmpleado(source.getUsuario().getRolEmpleado());
                skip().setJuegosAsignados(null);
            }
        });

        EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
        empleadoDTO.setJuegosAsignados(mapJuegos(empleado.getJuegos()));

        return empleadoDTO;
    }


    /**
     * Método que realiza el mapeo entre la entidad Lista y mapea Juegos a JuegosDTO
     * @param juegos juegos que se quiere mapear
     * @return lista de juegosDTO con los datos de los juegos
     */
    private List<JuegoDTO> mapJuegos(List<Juego> juegos) {
        List<JuegoDTO> juegosDTO = new ArrayList<>();
        for (Juego juego : juegos) {
            JuegoDTO juegoDTO = new JuegoDTO();
            juegoDTO.setIdJuego(juego.getIdJuego());
            juegoDTO.setNombreJuego(juego.getNombreJuego());
            juegosDTO.add(juegoDTO);
        }
        return juegosDTO;
    }


    /**
     * Método que realiza el mapeo entre la entidad Entrada a Entrada DTO
     * @param entrada entrada que se quiere mapear
     * @return entradaDTO con los datos de la entrada
     */
    public EntradaDTO mapToEntradaDTO(Entrada entrada) {
        return mapper.map(entrada, EntradaDTO.class);
    }


    /**
     * Método que realiza el mapeo entre EntradaDTO a Entidad Entrada
     * @param entradaDTO entrada que se quiere mapear
     * @return entrada con los datos de la entrada
     */
    public Entrada reverseMapToEntrada(EntradaDTO entradaDTO) {
        return mapper.map(entradaDTO, Entrada.class);
    }
};

