package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Juego")
public class Juego {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_juego;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion")
    private ClasificacionJuego clasificacion;

    private String nombre;

    private String descripcion;

    private boolean esActivo;

    private LocalDateTime fecha_registro;

}
