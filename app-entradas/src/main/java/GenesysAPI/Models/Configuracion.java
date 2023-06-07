package GenesysAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Configuracion")
public class Configuracion {

    @Id
    private String recurso;

    private String propiedad;

    private String valor;


}
