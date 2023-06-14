package entradasApp.exceptions;

public class EntradaNoEncontradaExcepcion extends RuntimeException {

    private String mensaje;

    public EntradaNoEncontradaExcepcion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() { return mensaje;}
}
