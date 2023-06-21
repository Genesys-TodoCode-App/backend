package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDTO {
    @JsonProperty("Id Juego")
    private Long idJuego;
    @JsonProperty("Nombre juego")
    private String nombreJuego;


}
