package entradasApp.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoLoginDTO {
    @JsonProperty("Usuario empleado")
    private String usuarioEmpleado;

    @JsonProperty("Contrasenia empleado")
    private String contraseniaEmpleado;

    @JsonProperty("Rol empleado")
    private RolEmpleado rolEmpleado;


}
