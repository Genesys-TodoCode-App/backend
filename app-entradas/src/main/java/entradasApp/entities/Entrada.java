package entradasApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Clase entrada que representa una entrada en la base de datos.
 * Contiene marcadores de JPA, Lombok y Jackson para la serialización de objetos.
 * ManyToOne tiene una relacion con los juegos al que pertenece la entrada.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entradas")
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entradas", unique = true, updatable = false)
    @JsonProperty("Id Entrada")
    private Long idEntrada;


    @Column(name = "cod_ident_entrada", length = 50)
    @JsonProperty("Codigo Identificacion Entrada")
    private String CodigoIdentificacionEntrada;


    @Column(name = "fecha_hora_utilizacion")
    @JsonProperty("Fecha y Hora Utilizacion")
    private LocalDateTime fechaHoraUtilizacion;


    /**
     * Relación Many-to-One con Juego.
     * Una entrada pertenece a un juego.
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_juegos")
    private Juego juego;


}
