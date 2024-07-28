package microstamp.authorization.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String resource, String key){
        super("Resource " + resource + " not found with key " + key);
    }
}
