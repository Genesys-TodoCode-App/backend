package entradasApp.services;

import entradasApp.entities.Entrada;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de servicio que maneja las operaciones relacionadas con las entradas.
 */
@Service
public class EntradaService {

    @Autowired
    private final EntradaRepository entradaRepository;

    /**
     * Constructor de la clase EntradaService.
     * @param entradaRepository repositorio de entradas.
     */
    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    /**
     * Crea una nueva entrada.
     * Si la entrada ya existe en la base de datos, se lanza una ExisteEnBaseDeDatosExcepcion.
     * @param entrada La entrada a crear.
     */
    public void create(Entrada entrada) {
        boolean existeEntrada = entradaRepository.existsById(entrada.getIdEntrada());
        if (existeEntrada) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe esta entrada en la base de datos");
        }
        entradaRepository.save(entrada);
    }

    /**
     * Obtiene todas las entradas.
     * @param pageable Paginación de la consulta.
     * @return Una lista de entradas.
     */
    public Page<Entrada> findAll(Pageable pageable) {
        return entradaRepository.findAll(pageable);
    }


    /**
     * Busca una entrada por su ID y la devuelve.
     * Si la entrada no existe, se devuelve null.
     * @param id El ID de la entrada a buscar.
     * @return La Entrada correspondiente a la entrada encontrada, o null si no se encontró ninguna entrada.
     */
    public Entrada findById(Long id) {
        return entradaRepository.findById(id).orElse(null);
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
}
