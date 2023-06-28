package entradasApp.mapper;


import entradasApp.dtos.EmpleadoDTO;
import entradasApp.dtos.UsuarioLoginDTO;
import entradasApp.entities.Empleado;
import entradasApp.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

    public EmpleadoDTO mapToEmpleadoDTO(Empleado empleado){
        return mapper.map(empleado, EmpleadoDTO.class);
    }
};

