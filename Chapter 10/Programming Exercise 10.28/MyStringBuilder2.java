
/**
 * (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following
 * methods
 * (name the new class MyStringBuilder2):
 *
 * public MyStringBuilder2();
 * public MyStringBuilder2(char[] chars);
 * public MyStringBuilder2(String s);
 * public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
 * public MyStringBuilder2 reverse();
 * public MyStringBuilder2 substring(int begin);
 * public MyStringBuilder2 toUpperCase();
 *
 * @author martinfall
 */
public class MyStringBuilder2 {

    // Private data field
    private String s;

    /**
     * No-args constructor.
     */
    public MyStringBuilder2() {
        this("No-args constructor");
    }

    /**
     * Construct a MyStringBuilder2 object with a chars array parameter.
     *
     * @param chars
     */
    public MyStringBuilder2(char[] chars) {
        String s = "";

        for (int i = 0; i < chars.length; i++) {
            s = s + chars[i];
        }

        this.s = s;
    }

    /**
     * Construct a MyStringBuilder2 object with a String parameter.
     *
     * @param s
     */
    public MyStringBuilder2(String s) {
        this.s = s;
    }

    /**
     * Insert a String at the offset position.
     *
     * @param offset
     * @param s
     * @return
     */
    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        // Split the string at the offset character
        String[] split = this.s.split(this.s.charAt(offset) + "");
        // Create and return a new MyStringBuilder2 object
        return new MyStringBuilder2(split[0] + s.s + this.s.charAt(offset) + split[1]);
    }

    /**
     * Returns a MyStringBuilder2 object with reversed contents.
     *
     * @return
     */
    public MyStringBuilder2 reverse() {
        String s = "";
        for (int i = 0; i < this.s.length(); i++) {
            s = this.s.charAt(i) + s;
        }
        return new MyStringBuilder2(s);
    }

    /**
     * Returns a MyStringBuilder2 substring from begin until object length - 1.
     *
     * @param begin
     * @return
     */
    public MyStringBuilder2 substring(int begin) {
        return new MyStringBuilder2(this.s.substring(begin));
    }

    /**
     * Returns a MyStringBuilder2 object in upper case.
     *
     * @return
     */
    public MyStringBuilder2 toUpperCase() {
        return new MyStringBuilder2(this.s.toUpperCase());
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.s.length(); i++) {
            s = s + this.s.charAt(i);
        }

        return s;
    }
}
