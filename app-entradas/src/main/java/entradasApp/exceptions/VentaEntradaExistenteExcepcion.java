package entradasApp.exceptions;

public class VentaEntradaExistenteExcepcion extends RuntimeException {

    private Long id;

    public VentaEntradaExistenteExcepcion(Long id){
        super("La Venta de entradas con el id; " + id + "ya existe.");
    }

    public Long getId() {
        return id;
    }
}
