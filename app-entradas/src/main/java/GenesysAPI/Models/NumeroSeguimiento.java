package GenesysAPI.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "NumeroSeguimiento")
public class NumeroSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumeroSeguimiento;

    private int ultimoNumero;

    private int cantidadDigitos;

    private String gestion;

    private LocalDateTime fechaActualizacion;

}
