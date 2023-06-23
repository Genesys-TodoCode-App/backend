package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "id_venta_entradas", unique = true, updatable = false)
    @JsonProperty("Id Venta Entradas")
    private Long idVentaEntrada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_entradas")
    @JsonManagedReference
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "id_empleados")
    @JsonBackReference
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_compradores")
    @JsonBackReference
    private Comprador compradorEntrada;

    @Column(name = "monto_ventas")
    @JsonProperty("Monto Venta")
    private BigDecimal montoVenta;

    @Column(name = "fecha_ventas")
    @JsonProperty("Fecha Venta")
    private LocalDateTime fechaVenta;
}



