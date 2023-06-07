package GenesysAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    private int id_empresa;

    private String urlLogo;

    private String nombreLogo;

    private String numeroDocumento;

    private String nombre;

    private String correo;

    private String direccion;

    private String telefono;

    private BigDecimal porcentajeImpuesto;

    private String simboloMoneda;

}
