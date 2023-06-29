package entradasApp.config;


import org.modelmapper.ModelMapper;
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
    ;@Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper;
        }
    }


