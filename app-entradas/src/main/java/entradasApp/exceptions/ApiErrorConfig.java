package entradasApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiErrorConfig {
    private String mensaje;
    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;
}
