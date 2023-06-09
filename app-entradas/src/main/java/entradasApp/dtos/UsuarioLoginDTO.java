package entradasApp.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase UsuarioLoginDTO que representa un objeto empleado para el inicio de sesión.
 * Contiene anotaciones de Lombok para generar automáticamente los constructores, getters, setters y otros métodos.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioLoginDTO {

    @JsonProperty("Id Usuario")
    private Long idUsuario;

    @JsonProperty("Usuario empleado")
    private String nombreUsuario;

    @JsonProperty("Id empleado")
    private Long idEmpleado;

    @JsonProperty("Rol empleado")
    private RolEmpleado rolEmpleado;

    @JsonProperty("Token de sesión")
    private String tokenDeSesion;

    @JsonProperty("Mensaje")
    private String mensaje;


    /**
     * Constructor de la clase UsuarioLoginDTO generico
     * @param nombreUsuario nombre de usuario del empleado
     * @param o objeto empleado
     * @param o1 objeto empleado
     * @param s cadena de texto
     */
    public UsuarioLoginDTO(String nombreUsuario, Object o, Object o1, String s) {
    }
}
