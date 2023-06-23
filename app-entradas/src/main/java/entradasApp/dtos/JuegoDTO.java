package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
