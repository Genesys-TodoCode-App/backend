package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public EmpleadoDTO(String usuarioEmpleado, String contraseniaEmpleado, String string) {
    }
}
