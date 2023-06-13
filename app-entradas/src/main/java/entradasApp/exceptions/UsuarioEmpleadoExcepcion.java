package entradasApp.exceptions;

public class UsuarioEmpleadoExcepcion extends RuntimeException{

    private String usuarioEmpleado;

    public UsuarioEmpleadoExcepcion(String usuarioEmpleado){
        super("El usuario " + usuarioEmpleado + " ya existe");
        this.usuarioEmpleado = usuarioEmpleado;
    }
}
