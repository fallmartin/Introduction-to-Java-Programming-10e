
/**
 * Custom checked exception BinaryFormatException.
 *
 * @author martinfall
 */
public class BinaryFormatException extends NumberFormatException {

    public BinaryFormatException(String message) {
        super(message + " is not a binary string.");
    }

}
