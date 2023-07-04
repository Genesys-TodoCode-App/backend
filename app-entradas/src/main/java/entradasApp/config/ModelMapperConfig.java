package entradasApp.config;


import entradasApp.dtos.EntradaDTO;
import entradasApp.dtos.VentaEntradaDTO;
import entradasApp.entities.Entrada;
import entradasApp.entities.VentaEntrada;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de ModelMapper
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Bean para el ModelMapper
     * @return ModelMapper
     */
    @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
                        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper;
        }
    }


