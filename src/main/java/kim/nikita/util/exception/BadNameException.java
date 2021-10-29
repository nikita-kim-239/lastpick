package kim.nikita.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadNameException extends RuntimeException{

    public BadNameException()
    {}

    public BadNameException(String message)
    {
        super(message);
    }
    public BadNameException(Throwable cause)
    {
        super(cause);
    }

    public BadNameException(String message,Throwable cause)
    {
        super(message,cause);
    }

}
