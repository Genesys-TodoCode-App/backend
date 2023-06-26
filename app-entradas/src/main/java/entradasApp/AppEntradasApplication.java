package entradasApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
  title = "App Entradas Parque Diversiones",
  version = "1.0",
  description = "Project Genesys"))
public class AppEntradasApplication {

    /**
     * Método principal de la aplicación entradasApp.
     * Este método inicia la aplicación y ejecuta las operaciones principales.
     *
     * @param args Los argumentos de línea de comandos pasados al programa.
     */
	public static void main(String[] args) {
		SpringApplication.run(AppEntradasApplication.class, args);
	}

}
