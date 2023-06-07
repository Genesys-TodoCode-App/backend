package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Concepto_Venta")
public class ConceptoVenta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_concepto_venta;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private HorarioJuego horario;

    private int cantidad;

    private BigDecimal precio;

    private boolean esActivo;

    private LocalDateTime fecha_registro;

}
