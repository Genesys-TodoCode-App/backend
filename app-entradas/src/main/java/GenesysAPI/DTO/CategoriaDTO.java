package GenesysAPI.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoriaDTO {

    private Integer id_categoria;

    private String nombre;

    private String descripcion;

   private int es_activo;

    private LocalDateTime fecha_registro;


}
