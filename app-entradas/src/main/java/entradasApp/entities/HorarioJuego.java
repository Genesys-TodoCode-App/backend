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
    @Column(name = "id_horario_juegos")
    private Long idHorarioJuegos;

    @Column(name = "nombre_juegos")
    private String nombreJuego;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime HoraFin;

    @ManyToOne
    @JoinColumn(name = "id_juegos")
    private Juego juego;
}
