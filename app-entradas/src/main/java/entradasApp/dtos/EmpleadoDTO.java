package entradasApp.dtos;

import entradasApp.entities.RolEmpleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmpleadoDTO {

    private Long idEmpleado;

    private String usuarioEmpleado;

    private String contraseniaEmpleado;

    private String nombreEmpleado;

    private String apellidoEmpleado;

    private String dniEmpleado;

    private String rutaALaFoto;

    private RolEmpleado rolEmpleado;

    public void setUsuarioEmpleado(String usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public void setRutaALaFoto(String rutaALaFoto) {
        this.rutaALaFoto = rutaALaFoto;
    }

    public void setRolEmpleado(RolEmpleado rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
