package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class EntradaDTO {
    @JsonProperty("Id Entrada")
    private Long idEntrada;

    @JsonProperty("Codigo Identificacion Entrada")
    private String codigoIdentificacionEntrada;

    @JsonProperty("Fecha y Hora Utilizacion")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaHoraUtilizacion;
}
