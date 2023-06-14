package entradasApp.exceptions;

public class JuegoExistenteExcepcion extends RuntimeException{

    private Long id;

    public JuegoExistenteExcepcion(Long id) {
        super("El juego con id " + id + " ya existe.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
