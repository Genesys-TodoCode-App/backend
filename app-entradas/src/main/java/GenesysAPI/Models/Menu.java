package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMenu;

    private String nombre;

    private String img;

    private String url;

    private boolean esActivo;

    private LocalDateTime fechaRegistro;

}
