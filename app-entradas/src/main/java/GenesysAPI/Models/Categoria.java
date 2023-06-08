package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;

    private String nombre;

    private String descripcion;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean es_activo;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_registro;

    @PrePersist
    public void prePersist() {
        if(fecha_registro == null ) {
            fecha_registro = LocalDateTime.now();
        }
    }


}
