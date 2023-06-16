package entradasApp.services;

import entradasApp.entities.Empleado;
import entradasApp.exceptions.NoEncontradoExcepcion;
import entradasApp.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private EmpleadoRepository empleadoRepository;

    public LoginService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado login(String usuario, String contrasenia){
        Empleado empleado = empleadoRepository.findByUsuarioEmpleado(usuario);

        if(empleado == null || !empleado.getContraseniaEmpleado().equals(contrasenia)) {
            throw new NoEncontradoExcepcion("Credenciales de inicio de sesion incorrectas.");
        }
        return empleado;
    }


}
