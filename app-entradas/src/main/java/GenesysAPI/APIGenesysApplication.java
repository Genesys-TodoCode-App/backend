package GenesysAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Genesys Parque Diversiones", version = "1.0", description = "Project Genesys"))
public class APIGenesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGenesysApplication.class, args);
	}

}
