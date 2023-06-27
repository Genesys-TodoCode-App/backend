package entradasApp.mapper;

import entradasApp.dtos.UsuarioEmpleadoDTO;
import entradasApp.entities.Usuario;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Usuario map(UsuarioEmpleadoDTO usuarioEmpleadoDTO) {
        return modelMapper.map(usuarioEmpleadoDTO.getUsuario(), Usuario.class);
    }
}
