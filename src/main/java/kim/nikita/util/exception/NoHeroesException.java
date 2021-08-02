/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Никита
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoHeroesException extends RuntimeException{
    
    public NoHeroesException()
        {}
    
    public NoHeroesException(String message)
        {
            super(message);
        }
    public NoHeroesException(Throwable cause)
        {
            super(cause);
        }
    
    public NoHeroesException(String message,Throwable cause)
        {
            super(message,cause);
        }
    
}
