package entradasApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración para permitir solicitudes CORS en la aplicación.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * Agrega configuraciones para permitir solicitudes CORS desde cualquier origen, con cualquier método y encabezados.
     *
     * @param registry El registro de configuración de CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}
