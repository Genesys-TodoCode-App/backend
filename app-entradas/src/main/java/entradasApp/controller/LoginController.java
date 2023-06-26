package entradasApp.controller;

import entradasApp.dtos.EmpleadoLoginDTO;
import entradasApp.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Esta clase es el controlador para el login de usuarios
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping
    public ResponseEntity<EmpleadoLoginDTO> login(@RequestParam String nombreUsuario,
                                                  @RequestParam String contraseniaUsuario) {
        ResponseEntity<EmpleadoLoginDTO> response = loginService.login(nombreUsuario, contraseniaUsuario);

        if(response.getBody() != null) {
            return response;
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
