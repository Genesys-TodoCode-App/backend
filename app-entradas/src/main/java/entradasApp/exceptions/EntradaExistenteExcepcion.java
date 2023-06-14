package entradasApp.exceptions;

public class EntradaExistenteExcepcion extends RuntimeException {
    private Long id;

    public EntradaExistenteExcepcion(Long id) {
        super("La entrada con id " + id + " ya existe.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
