package entradasApp.exceptions;

public class VentaEntradaNoEncontradaExcepcion extends RuntimeException{

    private String mensaje;

    public VentaEntradaNoEncontradaExcepcion(String mensaje) {
        super();
        this.mensaje = mensaje;
    }
    public String getMensaje(){ return mensaje;}
}
