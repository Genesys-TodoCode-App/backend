package entradasApp.repositories;

import entradasApp.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Usuario
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    /**
     * Método para obtener usuario por nombre de usuario
     * @param nombreUsuario el nombre de usuario
     * @return el usuario encontrado
     */
    Usuario findByNombreUsuario(String nombreUsuario);
}


