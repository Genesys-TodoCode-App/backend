package GenesysAPI.DTO;

import lombok.Data;

@Data
public class CategoriaDTO {

    private Integer id_categoria;

    private String nombre;

    private String descripcion;

   private int es_activo;


}
