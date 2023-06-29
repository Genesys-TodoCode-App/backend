package entradasApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

/**
 * ApiManejadorDeExcepciones contiene respuestas personalizadas a algunos errores.
 */
@ControllerAdvice
public class AppManejadorDeExcepciones extends ResponseEntityExceptionHandler {


    /**
     * Maneja la excepción de empleado no encontrado y devuelve una respuesta con el mensaje de error y código de estado apropiados.
     * @param ex      La excepción de empleado no encontrado.
     * @param request La solicitud web actual.
     * @return Una respuesta con el mensaje de error y código de estado apropiados.
     */
    @ExceptionHandler(NoEncontradoExcepcion.class)
    public ResponseEntity<Object> handleEmpleadoNoEncontradoExcepcion(NoEncontradoExcepcion ex, WebRequest request) {
        return new ResponseEntity<>(new ApiErrorConfig(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }


    /**
     * Maneja la excepción de existencia en base de datos y devuelve una respuesta con el mensaje de error y código de estado apropiados.     *
     * @param ex      La excepción de existencia en base de datos.
     * @param request La solicitud web actual.
     * @return Una respuesta con el mensaje de error y código de estado apropiados.
     */
    @ExceptionHandler(ExisteEnBaseDeDatosExcepcion.class)
    public ResponseEntity<Object> ExisteEnBaseDeDatosManejador(ExisteEnBaseDeDatosExcepcion ex, WebRequest request) {
        return new ResponseEntity<>(new ApiErrorConfig(ex.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now()), HttpStatus.CONFLICT);
    }
}
