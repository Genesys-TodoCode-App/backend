package entradasApp.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoLoginDTO {

    private String usuarioEmpleado;

    private String contraseniaEmpleado;


}
