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
    @Column(name = "id_usuarios",  nullable = false,  unique = true,  updatable = false)
    private Long id;

    @Column(name = "nombre_usuarios", length = 20, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenia_usuarios", length = 20)
    private String contraseniaUsuario;
}
