package entradasApp.exceptions;

public class CompradorNoEncontradoExcepcion extends RuntimeException{

    private String mensaje;

    public CompradorNoEncontradoExcepcion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() { return mensaje; }
}
