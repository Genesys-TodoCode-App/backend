package entradasApp.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase EmpleadoLoginDTO que representa un objeto empleado para el inicio de sesión.
 * Contiene anotaciones de Lombok para generar automáticamente los constructores, getters, setters y otros métodos.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoLoginDTO {

    @JsonProperty("Usuario empleado")
    private String usuarioEmpleado;


    @JsonProperty("Rol empleado")
    private RolEmpleado rolEmpleado;

    @JsonProperty("Token de sesión")
    private String tokenDeSesion;

    @JsonProperty("Mensaje")
    private String mensaje;


}
