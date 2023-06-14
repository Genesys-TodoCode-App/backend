package entradasApp.exceptions;

public class CompradorExistenteExcepcion extends RuntimeException {

    private Long id;

    public CompradorExistenteExcepcion(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
