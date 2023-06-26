package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clase que define los Horarios de los Juegos
 * Contiene anitaciones de Lombok, Jackson y JPA para la serialización de objetos.
 */
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin")
    @JsonProperty("Hora Fin")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime HoraFin;

}
