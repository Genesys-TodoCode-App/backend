package entradasApp.dtos;


import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoLoginDTO {

    private String usuarioEmpleado;

    private String contraseniaEmpleado;

    private RolEmpleado rolEmpleado;


}
