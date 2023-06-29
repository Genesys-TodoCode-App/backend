package entradasApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase CompradorDTO que representa un comprador.
 * Contiene métodos de Lombok de getters y setters, constructor vacío y constructor completo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompradorDTO {

    @JsonProperty("Id Comprador")
    private Long idComprador;

    @JsonProperty("Nombre Comprador")
    private String nombreComprador;

    @JsonProperty("Apellido Comprador")
    private String apellidoComprador;

    @JsonProperty("Pase de oro")
    private Boolean paseDeOro;

}
