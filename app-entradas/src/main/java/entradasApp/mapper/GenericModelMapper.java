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
    
    public static GenericModelMapper singleInstance(){
        if (instance == null){
            instance = new GenericModelMapper();
        }
        return instance;
    }
    
    public UsuarioLoginDTO mapToUsuarioLoginDTO(Usuario usuario){
        return mapper.map(usuario, UsuarioLoginDTO.class);}

    public CompradorDTO mapToCompradorDTO(Comprador comprador){
        return mapper.map(comprador, CompradorDTO.class);
    }

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



    public EntradaDTO mapToEntradaDTO(Entrada entrada) {
        return mapper.map(entrada, EntradaDTO.class);
    }

    public Entrada reverseMapToEntrada(EntradaDTO entradaDTO) {
        return mapper.map(entradaDTO, Entrada.class);
    }
};

