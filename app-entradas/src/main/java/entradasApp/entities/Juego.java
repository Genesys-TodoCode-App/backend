package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * Clase Juego que representa un Juego con sus atributos.
 * Contiene anotaciones de Lombok, Jackson y JPA para la serialización de objetos.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "juegos")
public class Juego {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juegos", unique = true, updatable = false)
    @JsonProperty("Id Juegos")
    private Long idJuego;


    @Column(name = "nombre_juegos", length = 50)
    @JsonProperty("Nombre Juegos")
    private String nombreJuego;


    @Column(name = "precio_juegos", length = 10)
    @JsonProperty("Precio Juegos")
    private BigDecimal precioJuego;


    @Column(name = "cobro_pase_oro")
    @JsonProperty("Cobro Pase Oro")
    private boolean cobroPaseOro;


    @Column(name = "juegos_activos")
    @JsonProperty("Juegos Activos")
    private boolean juegoActivo;


    @Column(name = "rutas_a_las_fotos")
    @JsonProperty("Rutas a las fotos")
    private String rutaALaFoto;


    @Column(name = "descripciones")
    @JsonProperty("Descripciones")
    private String descripciones;


    /**
     * Relación One-to-Many con HorarioJuego.
     * Un juego puede tener varios horarios.
     * La propiedad horarios representa la lista de horarios asociados al juego.
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "juegos_horarios",
        joinColumns = @JoinColumn(name = "id_juegos"),
        inverseJoinColumns = @JoinColumn(name = "id_horarios")
    )
    @JsonIgnoreProperties("empleados")
    private List<HorarioJuego> horarios;

}

