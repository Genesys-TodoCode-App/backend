package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MenuRol")
public class MenuRol {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMenuRol;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;

    private boolean esActivo;

    private LocalDateTime fechaRegistro;

}
