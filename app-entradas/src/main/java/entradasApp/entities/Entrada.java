package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrada;
    private String codigoIdentificacionEntrada;
    private LocalDate fechaHoraUtilizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_juego")
    private Juego juego;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comprador comprador;

    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleadoVendedor;

}
