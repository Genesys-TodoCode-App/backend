package entradasApp.exceptions;

public class JuegoNoEncontradoExcepcion extends RuntimeException{

    private String mensaje;

    public JuegoNoEncontradoExcepcion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return  mensaje;
    }

}
