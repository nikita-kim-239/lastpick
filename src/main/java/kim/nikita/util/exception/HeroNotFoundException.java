/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class HeroNotFoundException extends RuntimeException {

    public HeroNotFoundException() {
    }

    public HeroNotFoundException(String message) {
        super(message);
    }

    public HeroNotFoundException(Throwable cause) {
        super(cause);
    }

    public HeroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
