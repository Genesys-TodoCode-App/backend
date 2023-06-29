package entradasApp.services;
;
import entradasApp.entities.Usuario;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import entradasApp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


/**
 * Clase de servicio que maneja las operaciones relacionadas con los usuarios.
 */
@Service
public class UsuarioService {


    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final EmpleadoRepository  empleadoRepository;


    /**
     * Constructor de la clase UsuarioService
     *
     * @param usuarioRepository  Repositorio de usuarios.
     * @param empleadoRepository Repositorio de empleados.
     */
    public UsuarioService(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }


    /**
     * Crea un nuevo usuario.
     * @param usuario El usuario a crear.
     * @return El usuario creado.
     */
    public Usuario create(Usuario usuario) {
        boolean existeUsuario = usuarioRepository.existsById(usuario.getIdUsuario());
        if (existeUsuario) {
            throw new ExisteEnBaseDeDatosExcepcion("Este usuario ya existe.");
        }
        return usuarioRepository.save(usuario);
    }


    /**
     * Obtiene todos los usuarios.
     * @return Una colección de usuarios.
     */
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    /**
     * Busca un usuario por su ID.
     * @param id El ID del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    /**
     * Actualiza un usuario existente.
     * @param id El ID del usuario a actualizar.
     * @param usuario El usuario con los nuevos datos.
     */
    public void update(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setContraseniaUsuario(usuario.getContraseniaUsuario());
            usuarioExistente.setRolEmpleado(usuario.getRolEmpleado());
            usuarioRepository.save(usuario);
        } else {
            throw new NoEncontradoExcepcion(" Usuario con el id: " + id + "no encontrado");
        }
    }


    /**
     * Elimina un usuario por su ID.
     * @param id El ID del usuario a eliminar.
     */
    public void deleteById(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Ocurrió un error al eliminar el Usuario");
        }
    }

}
