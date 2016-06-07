
package util;

public class ErroUtil extends Exception{

    public ErroUtil(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ErroUtil(String message){ 
        super(message);
    }
}