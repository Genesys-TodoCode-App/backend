package entradasApp.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long idVentaEntrada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_entradas")
    @JsonManagedReference
    // Esta anotación indica que esta entidad controla la relación
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "id_empleados")
    @JsonBackReference
    // Esta anotación indica que la relación es manejada por otra entidad
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_compradores")
    @JsonBackReference // Esta anotación indica que la relación es manejada por otra entidad
    private Comprador compradorEntrada;

    @Column(name = "monto_ventas")
    private BigDecimal montoVenta;

    @Column(name = "fecha_ventas")
    private LocalDateTime fechaVenta;
}



