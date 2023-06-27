package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase EmpleadoDTO que representa un objeto empleado con sus datos.
 * Contiene anotaciones de Lombok para generar automáticamente los constructores, getters, setters y otros métodos.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDTO {


    @JsonProperty("Id Empleado")
    private Long idEmpleado;


    @JsonProperty("Nombre empleado")
    private String nombreEmpleado;


    @JsonProperty("Apellido empleado")
    private String apellidoEmpleado;


    @JsonProperty("DNI empleado")
    private String dniEmpleado;


    @JsonProperty("Ruta a la foto")
    private String rutaALaFoto;


    @JsonProperty("Rol empleado")
    private RolEmpleado rolEmpleado;

    @JsonProperty("Id usuario")
    private Long idUsuario;


    /**
     * Constructor de EmpleadoDTO con parámetros específicos.
     *
     * @param usuarioEmpleado    El usuario del empleado.
     * @param contraseniaEmpleado La contraseña del empleado.
     * @param string              Un parámetro adicional de tipo String.
     */
    public EmpleadoDTO(String usuarioEmpleado, String contraseniaEmpleado, String string) {
    }
}
