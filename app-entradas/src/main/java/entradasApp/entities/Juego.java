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
    @Column(name = "id_juegos")
    private Long idJuego;
    @Column(name = "nombre_juegos")
    private String nombreJuego;
    @Column(name = "precio_juegos")
    private Integer precioJuego;


}
