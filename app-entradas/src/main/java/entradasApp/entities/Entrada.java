package entradasApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entradas", nullable = false, unique = true, updatable = false)
    private Long idEntrada;

    @Column(name = "cod_ident_entrada", length = 20)
    private String codigoIdentificacionEntrada;

    @Column(name = "fecha_hora_utilizacion")
    private LocalDateTime fechaHoraUtilizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_juegos")
    private Juego juego;



}
