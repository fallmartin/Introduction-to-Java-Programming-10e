
/**
 * (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new
 * class MyString1):
 *
 * public MyString1(char[] chars);
 * public char charAt(int index);
 * public int length();
 * public MyString1 substring(int begin, int end);
 * public MyString1 toLowerCase();
 * public boolean equals(MyString1 s);
 * public static MyString1 valueOf(int i);
 *
 * @author martinfall
 */
public class MyString1 {

    private char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public char charAt(int index) {
        return chars[index];
    }

    public int length() {
        return this.chars.length;
    }

    public MyString1 substring(int begin, int end) {
        String substring = "";

        for (int i = begin; i <= end; i++) {
            substring += this.chars[i];
        }
        return new MyString1(substring.toCharArray());
    }

    public MyString1 toLowerCase() {
        String substring = "";

        for (int i = 0; i < this.length(); i++) {
            substring += Character.toLowerCase(this.chars[i]);
        }
        return new MyString1(substring.toCharArray());
    }

    public boolean equals(MyString1 s) {
        if (this.length() != s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (this.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        String substring = "";

        while (i > 0) {
            substring = Integer.toString(i % 10) + substring;
            i /= 10;
        }

        return new MyString1(substring.toCharArray());
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.length(); i++) {
            s += this.charAt(i);
        }
        return s;
    }
}
