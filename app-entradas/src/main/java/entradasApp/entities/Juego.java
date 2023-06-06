package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juegos")
    private Long idJuego;

    private String nombreJuego;

    private BigDecimal precioJuego;

    @ManyToOne
    @JoinColumn(name = "id_empleados")
            private EmpleadoJuego empleadoJuego;

}
