package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_compradores",  unique = true,  updatable = false)
    private Long idComprador;

    @Column(name = "nombre_compradores", length = 20)
    private String nombreComprador;

    @Column(name = "apellido_compradores", length = 20)
    private String apellidoComprador;

    @Column(name = "dni_compradores", length = 11)
    private String dniComprador;

    @Column(name = "correo_electronico_comprador", length = 50)
    private String correoElectronicoComprador;

    @Column(name = "pase_de_oro", length = 5)
    private boolean paseDeOro;

}
