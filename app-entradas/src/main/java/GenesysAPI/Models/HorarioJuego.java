package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "HorarioJuego")
public class HorarioJuego {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_horario;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    private LocalTime hora_inicio;

    private LocalTime hora_fin;

    private boolean esActivo;

    private LocalDateTime fecha_registro;

}
