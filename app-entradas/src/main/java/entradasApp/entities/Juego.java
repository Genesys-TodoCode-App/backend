package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juegos", unique = true, nullable = false, updatable = false)
    private Long idJuego;

    @Column(name = "nombre_juegos", length = 20)
    private String nombreJuego;

    @Column(name = "precio_juegos", length = 10)
    private Integer precioJuego;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleados_aut", nullable = false)
    private Empleado empleadoAutorizado;


}
