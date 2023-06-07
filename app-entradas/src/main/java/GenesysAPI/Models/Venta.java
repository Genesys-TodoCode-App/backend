package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private HorarioJuego horario;

    private String codigo_identificacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_taquilla")
    private Taquilla taquilla;

    private BigDecimal subTotal;

    private BigDecimal impuestoTotal;

    private BigDecimal Total;

    private LocalDateTime fecha_venta;


}
