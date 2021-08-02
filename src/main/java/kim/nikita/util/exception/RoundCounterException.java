/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;




@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoundCounterException extends RuntimeException{
    
    public RoundCounterException()
        {}
    
    public RoundCounterException(String message)
        {
            super(message);
        }
    public RoundCounterException(Throwable cause)
        {
            super(cause);
        }
    
    public RoundCounterException(String message,Throwable cause)
        {
            super(message,cause);
        }
    
}
