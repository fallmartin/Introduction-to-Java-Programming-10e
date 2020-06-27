
/**
 * (Implement the Character class) The Character class is provided in the Java
 * library. Provide your own implementation for this class. Name the new class
 * MyCharacter.
 *
 * @author martinfall
 */
public class MyCharacter {

    private char myChar;

    /**
     * Constructor
     *
     * @param myChar
     */
    public MyCharacter(char myChar) {
        this.myChar = myChar;
    }

    /**
     * Return true if digit
     *
     * @param myChar
     * @return
     */
    public static boolean isDigit(char myChar) {
        return (myChar >= '0' && myChar <= '9');
    }

    /**
     * Return true if letter
     *
     * @param myChar
     * @return
     */
    public static boolean isLetter(char myChar) {
        return (myChar >= 'a' && myChar <= 'z'
                || myChar >= 'A' && myChar <= 'Z');
    }

    /**
     * Return true if letter or digit
     *
     * @param myChar
     * @return
     */
    public static boolean isLetterOrDigit(char myChar) {
        return isLetter(myChar) || isDigit(myChar);
    }

    /**
     * Return true if lower case
     *
     * @param myChar
     * @return
     */
    public static boolean isLowerCase(char myChar) {
        return (myChar >= 'a' && myChar <= 'z');
    }

    /**
     * Return true if upper case
     *
     * @param myChar
     * @return
     */
    public static boolean isUpperCase(char myChar) {
        return (myChar >= 'A' && myChar <= 'Z');
    }

    /**
     * Return true if the character is a whitespace
     *
     * @param myChar
     * @return
     */
    public static boolean isWhitespace(char myChar) {
        // return Character.isWhitespace(myChar);

        // A character is a Java whitespace character if and only if it satisfies 
        // one of the following criteria:
        //
        //It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, 
        // or PARAGRAPH_SEPARATOR) but is not also a non-breaking space 
        // (‘\u00A0’, ‘\u2007’, ‘\u202F’).
        return ((((myChar == Character.SPACE_SEPARATOR
                || myChar == Character.LINE_SEPARATOR
                || myChar == Character.PARAGRAPH_SEPARATOR)
                && !(myChar == '\u00A0') || myChar == '\u2007' || myChar == '\u202F'))
                //It is ‘\t’, U+0009 HORIZONTAL TABULATION.
                || (myChar == '\t')
                //It is ‘\n’, U+000A LINE FEED.
                || myChar == '\n'
                //It is ‘\u000B’, U+000B VERTICAL TABULATION.
                || myChar == '\u000B'
                //It is ‘\f’, U+000C FORM FEED.
                || myChar == '\f'
                //It is ‘\r’, U+000D CARRIAGE RETURN.
                || myChar == '\r'
                //It is ‘\u001C’, U+001C FILE SEPARATOR.
                || myChar == '\u001C'
                //It is ‘\u001D’, U+001D GROUP SEPARATOR.
                || myChar == '\u001D'
                //It is ‘\u001E’, U+001E RECORD SEPARATOR.
                || myChar == '\u001E'
                //It is ‘\u001F’, U+001F UNIT SEPARATOR.
                || myChar == '\u001F');
    }

    /**
     * Convert a Character object to lower case and return a MyCharacter object
     *
     * @param myChar
     * @return
     */
    public static MyCharacter toLowerCase(char myChar) {
        if (myChar >= 97 && myChar <= 122) {
            return new MyCharacter(myChar);
        } else if (myChar >= 65 && myChar <= 90) {
            return new MyCharacter((char) (myChar + 32));
        } else {
            return new MyCharacter(myChar);
        }
    }

    /**
     * Convert a Character object to upper case and return a MyCharacter object
     *
     * @param myChar
     * @return
     */
    public static MyCharacter toUpperCase(char myChar) {
        if (myChar >= 65 && myChar <= 90) {
            return new MyCharacter(myChar);
        } else if (myChar >= 97 && myChar <= 122) {
            return new MyCharacter((char) (myChar - 32));
        } else {
            return new MyCharacter(myChar);
        }
    }

    /**
     * Compare method
     *
     * @param myChar1
     * @param myChar2
     * @return
     */
    public static int compare(MyCharacter myChar1, MyCharacter myChar2) {
        return Character.compare(myChar1.myChar, myChar2.myChar);
    }

    /**
     * CompareTo method
     *
     * @param myChar
     * @return
     */
    public int compareTo(MyCharacter myChar) {
        return Character.valueOf(this.myChar).compareTo(myChar.myChar);
        // return Character.valueOf(myChar1.myChar).compareTo(myChar2.myChar);
    }

    @Override
    public String toString() {
        return String.valueOf(myChar);
    }
}
