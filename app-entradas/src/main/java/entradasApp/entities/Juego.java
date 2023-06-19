package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juegos", unique = true, nullable = false, updatable = false)
    private Long idJuego;

    @Column(name = "nombre_juegos", length = 50)
    private String nombreJuego;

    @Column(name = "precio_juegos", length = 10)
    private Integer precioJuego;


    @Column(name = "cobro_pase_oro")
    private boolean cobroPaseOro;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
        name = "juegos_horarios",
        joinColumns = @JoinColumn(name = "id_juegos"),
        inverseJoinColumns = @JoinColumn(name = "id_horarios")
    )
    private List<HorarioJuego> horarios;


}
