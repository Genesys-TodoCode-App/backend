package entradasApp.mapper;

import entradasApp.dtos.UsuarioEmpleadoDTO;
import entradasApp.entities.Empleado;
import org.modelmapper.ModelMapper;

public class EmpleadoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Empleado map(UsuarioEmpleadoDTO usuarioEmpleadoDTO) {
        return modelMapper.map(usuarioEmpleadoDTO.getEmpleado(), Empleado.class);
    }
}
