package entradasApp.controller;

import entradasApp.entities.Usuario;
import entradasApp.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
  private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Usuario usuario) {
        usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> findAll(){
        Iterable<Usuario> listaDeUsuarios = usuarioService.findAll();
        return ResponseEntity.ok(listaDeUsuarios);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@Valid @PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioExistente = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioExistente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
