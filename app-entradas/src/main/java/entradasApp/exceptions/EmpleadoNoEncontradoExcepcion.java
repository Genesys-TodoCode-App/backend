package entradasApp.exceptions;

public class EmpleadoNoEncontradoExcepcion extends RuntimeException{

    private String mensaje;

    public EmpleadoNoEncontradoExcepcion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
