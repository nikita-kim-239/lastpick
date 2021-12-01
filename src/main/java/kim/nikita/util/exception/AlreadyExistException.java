/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(Throwable cause) {
        super(cause);
    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
