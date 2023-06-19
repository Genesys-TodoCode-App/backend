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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_entradas")
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "id_empleados")
    private Empleado empleadoVendedor;

    @ManyToOne
    @JoinColumn(name = "id_compradores")
    private Comprador compradorEntrada;

    @Column(name = "monto_ventas")
    private BigDecimal montoVenta;

    @Column(name = "fecha_ventas")
    private LocalDateTime fechaVenta;
}
