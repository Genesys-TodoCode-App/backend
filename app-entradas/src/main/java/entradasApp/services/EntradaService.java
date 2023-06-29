package entradasApp.services;

import entradasApp.dtos.EntradaDTO;
import entradasApp.entities.Entrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.mapper.GenericModelMapper;
import entradasApp.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * Clase de servicio que maneja las operaciones relacionadas con las entradas.
 */
@Service
public class EntradaService {


    private final EntradaRepository entradaRepository;
    private final GenericModelMapper mapper;


    /**
     * Constructor de la clase EntradaService.
     *
     * @param entradaRepository repositorio de entradas.
     * @param mapper trae una configuración de ModelMapper
     */
    @Autowired
    public EntradaService(EntradaRepository entradaRepository,GenericModelMapper mapper) {
        this.entradaRepository = entradaRepository;
        this.mapper = mapper;
    }

    /**
     * Crea una nueva entrada.
     * Si la entrada ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     * @param entradaDTO La entrada a crear.
     */
    public void create(EntradaDTO entradaDTO) {
        boolean existeEntrada = entradaRepository.existsById(entradaDTO.getIdEntrada());
        if(existeEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("La entrada con el Id: " + entradaDTO.getIdEntrada() + " ya existe en la base de datos");
        }
        Entrada entrada = mapper.reverseMapToEntrada(entradaDTO);
        generarCodigoIdentificacionEntrada(entrada);
        entradaRepository.save(entrada);
    }


    /**
     * Obtiene todas las entradas.
     * @param pageable Paginación de la consulta.
     * @return Una lista de entradas.
     */
    public Page<EntradaDTO> findAll(Pageable pageable) {
        Page<Entrada> entradaPage = entradaRepository.findAll(pageable);
        return entradaPage.map((entrada) -> {
            EntradaDTO entradaDTO = mapper.mapToEntradaDTO(entrada);
            entradaDTO.setIdJuegos(entrada.getJuego() != null ? entrada.getJuego().getIdJuego() : null);
            entradaDTO.setNombreJuegos(entrada.getJuego() != null ? entrada.getJuego().getNombreJuego() : null);

            return entradaDTO;
        });
    }



    /**
     * Busca una entrada por su ID y la devuelve.
     * Si la entrada no existe, se devuelve null.
     *
     * @param id El ID de la entrada a buscar.
     * @return La Entrada correspondiente a la entrada encontrada, o null si no se encontró ninguna entrada.
     */
    public EntradaDTO findById(Long id) {
        Entrada entrada = entradaRepository.findById(id).orElse(null);
        if (entrada != null) {
            EntradaDTO entradaDTO = mapper.mapToEntradaDTO(entrada);
            entradaDTO.setIdJuegos(entrada.getJuego() != null ? entrada.getJuego().getIdJuego() : null);
            entradaDTO.setNombreJuegos(entrada.getJuego() != null ? entrada.getJuego().getNombreJuego() : null);
            return entradaDTO;
        } else {
            throw new NoEncontradoExcepcion("La entrada con el Id: " + id + " no ha sido encontrada");
        }
    }


    /**
     * Actualiza una entrada existente con los datos proporcionados en la entrada.
     * Si la entrada no existe, se lanza una NoEncontradoExcepcion.
     * @param id El ID de la entrada a actualizar.
     * @param entrada La Entrada con los nuevos datos de la entrada.
     */
    public void update(Long id, Entrada entrada) {
        Entrada entradaExistente = entradaRepository.findById(id).orElse(null);
        if (entradaExistente != null) {
            entradaExistente.setFechaHoraUtilizacion(entrada.getFechaHoraUtilizacion());
            entradaExistente.setJuego(entrada.getJuego());
            entradaRepository.save(entradaExistente);
        } else {
            throw new NoEncontradoExcepcion("La entrada con el Id: " + id + " no ha sido encontrada");
        }
    }


    /**
     * Elimina una entrada por su ID.
     * Si la entrada no existe, se lanza una EmptyResultDataAccessException.
     * @param id El ID de la entrada a eliminar.
     */
    public void deleteById(Long id) {
        try {
            entradaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar la entrada");
        }
    }

    public void generarCodigoIdentificacionEntrada(Entrada entrada) {
        String uuid = UUID.randomUUID().toString();
        String codigoIdentificacion = "CUE-" + uuid.substring(0, Math.min(uuid.length(), 24)) + "-TODOCODEPARK";
        entrada.setCodigoIdentificacionEntrada(codigoIdentificacion);
    }
}
