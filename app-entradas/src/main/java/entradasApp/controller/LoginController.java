package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final EmpleadoRepository empleadoRepository;

    public LoginController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String usuario, @RequestParam String contrasenia) {
        Empleado empleado = empleadoRepository.findByUsuarioEmpleado(usuario);

        if (empleado == null || !empleado.getContraseniaEmpleado().equals(contrasenia)) {
            throw new NoEncontradoExcepcion("Credenciales de inicio de sesion incorrectas");

        }
        return ResponseEntity.ok("Inicio de sesion exitoso");
    }
}
