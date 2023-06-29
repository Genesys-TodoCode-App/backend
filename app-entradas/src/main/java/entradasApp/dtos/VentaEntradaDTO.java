package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Clase que representa una entrada de venta
 * Contiene además anotaciones de Lombok con setters, getters y constructores
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntradaDTO {

    @JsonProperty("Id Venta Entradas")
    private Long idVentaEntrada;

    @JsonProperty("Monto Venta")
    private BigDecimal montoVenta;

    @JsonProperty("Fecha Venta")
    private LocalDateTime fechaVenta;

    @JsonProperty("Id Entrada")
    private Long idEntrada;

    @JsonProperty("compradorEntrada")
    private CompradorDTO compradorEntrada;
}
