package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "horarios_juego")
public class HorarioJuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horarios", unique = true, updatable = false)
    @JsonProperty("Id Horario Juego")
    private Long idHorarioJuego;

    @Column(name = "hora_inicio")
    @JsonProperty("Hora Inicio")
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin")
    @JsonProperty("Hora Fin")
    private LocalDateTime HoraFin;

}
