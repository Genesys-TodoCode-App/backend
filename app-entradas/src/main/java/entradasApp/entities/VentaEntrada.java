package entradasApp.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ventas_entradas")
public class VentaEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta_entrada")
    private Long idVentaEntrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrada")
    private Entrada entrada;

    @Column(name = "monto_venta")
    private BigDecimal montoVenta;

    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;
}
