package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_concepto_venta")
    private ConceptoVenta conceptoVenta;

    private String Categoria_Concepto;

    private String nombre_juego;

    private String Clasificacion_Juego;

    private String nombre_cliente;

    private int cantidad;

    private BigDecimal precio;

    private BigDecimal total;


}
