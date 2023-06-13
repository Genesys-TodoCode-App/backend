package entradasApp.exceptions;

public class EmpleadoExistenteExcepcion extends RuntimeException {

    private Long id;

    public EmpleadoExistenteExcepcion(Long id) {
        super("El usuario con id " + id + " ya existe.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
