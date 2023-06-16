package entradasApp.controller;

import entradasApp.dtos.EmpleadoDTO;
import entradasApp.dtos.EmpleadoLoginDTO;
import entradasApp.entities.Empleado;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<EmpleadoLoginDTO> login(@RequestParam String usuario, @RequestParam String contrasenia) {
        try {
            Empleado empleado =loginService.login(usuario, contrasenia);
            EmpleadoLoginDTO empleadoDTO = new EmpleadoLoginDTO(empleado.getUsuarioEmpleado(),empleado.getContraseniaEmpleado().toString());
            return ResponseEntity.ok(empleadoDTO);
        } catch (NoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}

