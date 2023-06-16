package entradasApp.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ventas_entradas")
public class VentaEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta_entradas", nullable = false, unique = true, updatable = false)
    private Long idVentaEntrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entradas")
    private Entrada entrada;

    @Column(name = "monto_ventas")
    private BigDecimal montoVenta;

    @Column(name = "fecha_ventas")
    private LocalDateTime fechaVenta;
}
