package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Taquilla")
public class Taquilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_taquilla;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String nombre;

    private String descripcion;

    private boolean esActivo;

    private LocalDateTime fechaRegistro;

}
