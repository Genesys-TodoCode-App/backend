package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Membrecia")
public class Membrecia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_membrecia;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    private LocalDateTime fecha_inicio;

    private LocalDateTime fecha_vencimiento;

    private boolean estado;

    private LocalDateTime fecha_registro;

}
