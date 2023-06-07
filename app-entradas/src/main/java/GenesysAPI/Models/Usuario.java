package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    private String nombre_completo;

    private String correo;

    private String telefono;

    private String urlFoto;

    private String nombreFoto;

    private String clave;

    private boolean esActivo;

    private LocalDateTime fechaRegistro;

}
