package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_cliente;

    private String nombre_completo;

    private String email;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_membrecia")
    private Membrecia membrecia;

    private boolean esActivo;

    private LocalDateTime fecha_registro;

}
