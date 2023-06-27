package entradasApp.mapper;

import entradasApp.dtos.VentaEntradaDTO;
import entradasApp.entities.VentaEntrada;
import org.modelmapper.ModelMapper;

public class VentaEntradaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private VentaEntradaMapper() {

    }

    public static VentaEntradaDTO toDTO(VentaEntrada ventaEntrada) {
        VentaEntradaDTO ventaEntradaDTO = modelMapper.map(ventaEntrada, VentaEntradaDTO.class);
        ventaEntradaDTO.setIdVentaEntradas(ventaEntrada.getIdVentaEntrada());
        ventaEntradaDTO.setIdEntrada(ventaEntrada.getEntrada().getIdEntrada());
        return ventaEntradaDTO;
    }

    public static VentaEntrada toEntity(VentaEntradaDTO ventaEntradaDTO) {
        VentaEntrada ventaEntrada = modelMapper.map(ventaEntradaDTO, VentaEntrada.class);
        return ventaEntrada;
    }
}
