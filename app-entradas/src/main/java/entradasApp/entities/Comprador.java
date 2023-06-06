package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_compradores")
    private Long idComprador;
    private String nombreComprador;
    private String apellidoComprador;
    private String correoElectronicoComprador;
    private boolean paseDeOro;

    @ManyToOne
    @JoinColumn(name = "id_juegos")
    private Juego juego;
}
