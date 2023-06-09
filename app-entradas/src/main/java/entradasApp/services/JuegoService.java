package entradasApp.services;

import entradasApp.dtos.JuegoDTO;
import entradasApp.entities.Juego;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.repositories.JuegoRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase de servicio que maneja las operaciones relacionadas con los juegos.
 * Al y tener relacion con otras clases, por integridad no se puede borrar
 * Se debe hacer un soft delete
 */
@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;

    private final ModelMapper modelMapper;


    /**
     * Constructor de la clase JuegoService
     *
     * @param juegoRepository El repositorio de juegos.
     * @param modelMapper El mapeador de objetos.
     */
    public JuegoService(JuegoRepository juegoRepository, ModelMapper modelMapper) {
        this.juegoRepository = juegoRepository;
        this.modelMapper = modelMapper;
    }


    /**
     * Crea un nuevo juego.
     * Se hace una comprobación de que el juego no exista en la base de datos y si existe se arroja una ExisteEnBaseDeDatosExcepcion.
     * @param juego El juego a crear.
     */
    public void create(Juego juego) {
        boolean existeJuego = juegoRepository.existsById(juego.getIdJuego());
        if (existeJuego) {
            throw new ExisteEnBaseDeDatosExcepcion("Ya existe en base de datos este juego");
        }
        juegoRepository.save(juego);
    }


    /**
     * Devuelve todos los juegos de la base de datos.
     *
     * @return un iterable con todos los juegos
     */
    public Iterable<JuegoDTO> findAll() {
        Iterable<Juego> juegos = juegoRepository.findAll();
        List<JuegoDTO> juegoDTOs = new ArrayList<>();

        for (Juego juego : juegos) {
            JuegoDTO juegoDTO = modelMapper.map(juego, JuegoDTO.class);
            juegoDTOs.add(juegoDTO);
        }
        return juegoDTOs;
    }



    /**
     * Busca un juego por su ID.
     * @param id El ID del juego a buscar.
     * @return El juego encontrado o null si no se encuentra.
     */
    public Juego findById(Long id) {
        return juegoRepository.findById(id)
            .orElse(null);
    }


    /**
     * Actualiza un juego existente.
     * @param id El ID del juego a actualizar.
     * @param juego El juego con los nuevos datos.
     */
    public void update(Long id, Juego juego) {
        Juego juegoExistente = juegoRepository.findById(id).orElse(null);
        if (juegoExistente != null) {
            juegoExistente.setNombreJuego(juego.getNombreJuego());
            juegoExistente.setPrecioJuego(juego.getPrecioJuego());
            juegoExistente.setCobroPaseOro(juego.isCobroPaseOro());
            juegoExistente.setDescripciones(juego.getDescripciones());
            juegoExistente.setRutaALaFoto(juego.getRutaALaFoto());
            juegoExistente.setJuegoActivo(juego.isJuegoActivo());
            juegoExistente.setHorarios(juego.getHorarios());
            juegoRepository.save(juegoExistente);
        }
    }


    /**
     * Elimina un juego por su ID.
     * @param id El ID del juego a eliminar.
     */
    public void deleteById(Long id) {
        Juego juego = juegoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontré el juego con el id: " + id));
        juego.setJuegoActivo(false);
        juego.setPrecioJuego(null);
        juego.setCobroPaseOro(false);
        juego.setNombreJuego(null);
        juego.setRutaALaFoto(null);
        juego.setDescripciones(null);
        juego.setHorarios(null);
        juegoRepository.save(juego);
    }
}
