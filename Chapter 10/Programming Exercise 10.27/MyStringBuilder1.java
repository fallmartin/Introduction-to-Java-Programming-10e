
/**
 * (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder1):
 * public MyStringBuilder1(String s);
 * public MyStringBuilder1 append(MyStringBuilder1 s);
 * public MyStringBuilder1 append(int i);
 * public int length();
 * public char charAt(int index);
 * public MyStringBuilder1 toLowerCase();
 * public MyStringBuilder1 submatrix(int begin, int end);
 * public String toString();
 *
 * @author martinfall
 */
public class MyStringBuilder1 {

    // Private data field s
    private String s;

    /**
     * Constructor with String parameter s.
     *
     * @param s
     */
    public MyStringBuilder1(String s) {
        this.s = s;
    }

    /**
     * Appends a MyStringBuilder1 object to the calling MyStringBuilder1 object.
     *
     * @param s
     * @return
     */
    public MyStringBuilder1 append(MyStringBuilder1 s) {
        return new MyStringBuilder1(this.s + s);
    }

    /**
     * Appends an int object to the calling MyStringBuilder1 object.
     *
     * @param i
     * @return
     */
    public MyStringBuilder1 append(int i) {
        return new MyStringBuilder1(this.s + Integer.toString(i));
    }

    /**
     * Returns the length of the calling MyStringBuilder1 object.
     *
     * @return
     */
    public int length() {
        return this.s.length();
    }

    /**
     * Returns the character at index parameter.
     *
     * @param index
     * @return
     */
    public char charAt(int index) {
        return this.s.charAt(index);
    }

    /**
     * Returns a MyStringBuilder1 object in lower case.
     *
     * @return
     */
    public MyStringBuilder1 toLowerCase() {
        return new MyStringBuilder1(this.s.toLowerCase());
    }
    
    /**
     * Returns a submatrix of MyStringBuilder1 object from begin to end.
     * @param begin
     * @param end
     * @return
     */
    public MyStringBuilder1 submatrix(int begin, int end) {
        return new MyStringBuilder1(this.s.substring(begin, end));
    }
    
    @Override
    public String toString() {
        return this.s;
    }
}
