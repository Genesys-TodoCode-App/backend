package entradasApp.services;

import entradasApp.entities.Usuario;
import entradasApp.exceptions.ExisteEnBaseDeDatosExcepcion;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.UsuarioRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void create(Usuario usuario) {
        boolean existeUsuario = usuarioRepository.existsById(usuario.getIdUsuario());
        if (existeUsuario) {
            throw new ExisteEnBaseDeDatosExcepcion("Este usuario ya existe.");
        }
        usuarioRepository.save(usuario);
    }
    public Iterable<Usuario> findAll(){ return usuarioRepository.findAll(); }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public void update(Long id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setContraseniaEmpleado(usuario.getContraseniaEmpleado());
            usuarioExistente.setRolEmpleado(usuario.getRolEmpleado());
            usuarioRepository.save(usuario);
        } else {
            throw  new NoEncontradoExcepcion(" Usuario con el id: " + id + "no encontrado");
        }
    }
    public void deleteById(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw  new RuntimeException("Ocurrió un error al eliminar el Usuario");
        }
    }
}
