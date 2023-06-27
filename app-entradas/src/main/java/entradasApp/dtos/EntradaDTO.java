package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDTO {


    @JsonProperty("Id Entrada")
    private Long idEntrada;

    @JsonProperty("Codigo Identificacion Entrada")
    private String codigoIdentificacionEntrada;

    @JsonProperty("Fecha y Hora Utilizacion")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaHoraUtilizacion;

    @JsonProperty("Id juego")
    private Long idJuegos;

    @JsonProperty("Nombre del Juego")
    private String nombreJuegos;
}
