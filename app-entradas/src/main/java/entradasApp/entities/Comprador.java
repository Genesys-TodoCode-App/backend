package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("Id Comprador")
    private Long idComprador;

    @Column(name = "nombre_compradores", length = 20)
    @JsonProperty("Nombre Comprador")
    private String nombreComprador;

    @Column(name = "apellido_compradores", length = 20)
    @JsonProperty("Apellido Comprador")
    private String apellidoComprador;

    @Column(name = "dni_compradores", length = 11)
    @JsonProperty("DNI Comprador")
    private String dniComprador;

    @Column(name = "correo_electronico_comprador", length = 50)
    @JsonProperty("Correo Electronico Comprador")
    private String correoElectronicoComprador;

    @Column(name = "pase_de_oro", length = 5)
    @JsonProperty("Pase de Oro")
    private boolean paseDeOro;

}

