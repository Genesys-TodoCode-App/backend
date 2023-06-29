package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Clase JuegoDTO que representa un objeto juego con sus datos.
 * Contiene anotaciones de Lombok para generar automáticamente los constructores, getters, setters y otros métodos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDTO {


    @JsonProperty("Id Juego")
    private Long idJuego;

    @JsonProperty("Nombre juego")
    private String nombreJuego;

    @JsonProperty("Precio juego")
    private BigDecimal precioJuego;

    @JsonProperty("Cobro Pase Oro")
    private boolean cobroPaseOro;

    @JsonProperty("Juegos Activos")
    private boolean juegoActivo;

    @JsonProperty("Rutas a las fotos")
    private String rutaALaFoto;

    @JsonProperty("Descripciones")
    private String descripciones;


}
