package entradasApp.mapper;

import entradasApp.dtos.UsuarioLoginDTO;
import entradasApp.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class GenericModelMapper {

    private ModelMapper modelMapper;

    public void ModelMapperConfig() {
        this.modelMapper = new ModelMapper();
        configureMappings();
    }

    public GenericModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    private void configureMappings() {
        modelMapper.addMappings(new PropertyMap<Usuario, UsuarioLoginDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setNombreUsuario(source.getNombreUsuario());
                map().setRolEmpleado(source.getRolEmpleado());
            }
        });


    }
}

