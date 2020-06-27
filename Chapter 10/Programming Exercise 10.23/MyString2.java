
/**
 * (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new
 * class MyString2):
 * 
 * public MyString2(String s);
 * public int compare(String s);
 * public MyString2 substring(int begin);
 * public MyString2 toUpperCase();
 * public char[] toChars();
 * public static MyString2 valueOf(boolean b);
 *
 * @author martinfall
 */
public class MyString2 {
    private String s;

    public MyString2(String s) {
        this.s = s;
    }
    
    public int compare(String s) {
        return this.s.compareTo(s);
    }
    
    public MyString2 substring(int begin) {
        String s = "";
        
        for (int i = begin; i < this.s.length(); i++) {
            s = s + this.s.charAt(i);
        }
        // System.out.println(s);
        
        return new MyString2(s);
    }
    
    public MyString2 toUpperCase() {
        // System.out.println(this.s.toUpperCase());
        return new MyString2(this.s.toUpperCase());
    }
    
    public char[] toChars() {
        return this.toString().toCharArray();
    }
    
    public static MyString2 valueOf(boolean b) {
        if (b) {
            return new MyString2("TRUE");
        } else {
            return new MyString2("FALSE");
        }
    }

    @Override
    public String toString() {
        String string = "";
        
        for (int i = 0; i < s.length(); i++) {
            string = string + this.s.charAt(i);
        }   
        return string;
    } 
}
