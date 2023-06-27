package entradasApp.controller;

import entradasApp.entities.Usuario;
import entradasApp.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para las operaciones CRUD relacionadas con los usuarios.
 * Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los usuarios.
 * Los usuarios son objetos de la clase Usuario.
 * Este controlador está mapeado a la ruta "/login".
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    /**
     * Constructor de la clase UsuarioController.
     *
     * @param usuarioService El servicio de UsuarioService que se utilizará en el controlador.
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    /**
     * Método para crear un nuevo usuario.
     * Recibe un objeto Usuario en el cuerpo de la solicitud.
     *
     * @param usuario El objeto Usuario que se va a crear.
     * @return ResponseEntity con estado HTTP 201 (CREATED) si se crea el usuario correctamente.
     */
    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * Método para obtener todos los usuarios.
     *
     * @return ResponseEntity con una lista Iterable de Usuario en el cuerpo de la respuesta.
     */
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> findAll() {
        Iterable<Usuario> listaDeUsuarios = usuarioService.findAll();
        return ResponseEntity.ok(listaDeUsuarios);
    }


    /**
     * Método para actualizar un usuario existente.
     * Recibe el ID del usuario a actualizar y un objeto Usuario en el cuerpo de la solicitud.
     *
     * @param id      El ID del usuario a actualizar.
     * @param usuario El objeto Usuario con los nuevos datos.
     * @return ResponseEntity con el objeto Usuario existente en el cuerpo de la respuesta.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@Valid @PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioExistente);
    }


    /**
     * Método para buscar un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return ResponseEntity con el objeto Usuario encontrado en el cuerpo de la respuesta.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }


    /**
     * Método para eliminar un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @return ResponseEntity con estado HTTP 204 (NO_CONTENT) si se elimina el usuario correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
