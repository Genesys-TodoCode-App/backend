package entradasApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "App Entradas Parque Diversiones", version = "1.0", description = "Project Genesys"))
public class AppEntradasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEntradasApplication.class, args);
	}

}
