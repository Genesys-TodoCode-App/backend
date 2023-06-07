package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_rol;

    private String descripcion;

    private boolean esActivo;

    private LocalDateTime fechaRegistro;

}
