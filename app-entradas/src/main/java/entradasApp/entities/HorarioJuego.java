package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "horario_juegos")
public class HorarioJuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;

    private String nombreJuego;

    private LocalTime horaInicio;

    private LocalTime HoraFin;

    @ManyToOne
    @JoinColumn(name = "id_juegos")
    private Juego juego;
}
