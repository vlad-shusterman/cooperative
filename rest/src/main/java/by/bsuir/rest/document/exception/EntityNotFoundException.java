package by.bsuir.rest.document.exception;

/**
 * @author Vladislav Novitskiy
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
