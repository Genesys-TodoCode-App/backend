package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuarios")
    private int id;
    @Column(name = "nombre_usuarios")
    private String nombreUsuario;
    @Column(name = "contrasenia_usuarios")
    private String contraseniaUsuario;
}
