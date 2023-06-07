package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Clasificacion_Juego")
public class ClasificacionJuego {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_clasificacion;

    private String descripcion;

    private boolean esActivo;

    private LocalDateTime fecha_registro;


}
