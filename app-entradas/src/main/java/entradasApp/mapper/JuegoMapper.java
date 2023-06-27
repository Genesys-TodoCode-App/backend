package entradasApp.mapper;

import entradasApp.dtos.JuegoDTO;
import entradasApp.entities.Juego;
import org.modelmapper.ModelMapper;

public class JuegoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Juego map(JuegoDTO juegoDTO) {
        return modelMapper.map(juegoDTO, Juego.class);
    }
}
