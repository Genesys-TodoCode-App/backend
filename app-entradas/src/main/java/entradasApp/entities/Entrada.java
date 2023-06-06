package entradasApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrada;
    private String codigoIdentificacionEntrada;
    private LocalDate fechaHoraUtilizacion;

    @ManyToOne

    private Juego juego;

    @ManyToOne
    private Comprador comprador;

}
