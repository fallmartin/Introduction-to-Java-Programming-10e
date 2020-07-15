
/**
 * Custom checked exception HexFormatException extends Exception
 *
 * @author martinfall
 */
public class HexFormatException extends Exception {

    public HexFormatException(String message) {
        super(message + " is not a valid hex string.");
    }
}
