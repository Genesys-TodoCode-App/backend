package entradasApp.controller;

import entradasApp.repositories.UsuarioRepository;
import entradasApp.entities.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    @GetMapping("/{id}")
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
