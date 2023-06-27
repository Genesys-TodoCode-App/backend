package entradasApp.config;

import entradasApp.dtos.VentaEntradaDTO;
import entradasApp.entities.VentaEntrada;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<VentaEntrada, VentaEntradaDTO>() {
            @Override
            protected void configure() {
                map().setIdEntrada(source.getEntrada().getIdEntrada());
            }
        });

        return modelMapper;
    }

}
