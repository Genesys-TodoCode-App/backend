package entradasApp.dtos;

import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDTO {

    private Long idEmpleado;

    private String usuarioEmpleado;

    private String contraseniaEmpleado;

    private String nombreEmpleado;

    private String apellidoEmpleado;

    private String dniEmpleado;

    private String rutaALaFoto;

    private RolEmpleado rolEmpleado;


}
