/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class TestMyCharacter {
    public static void main(String[] args) {
        // Testing the constructor
        System.out.println("Testing the constructor");
        MyCharacter letter = new MyCharacter('m');
        MyCharacter digit = new MyCharacter('9');
        System.out.println();
        
        // Testing the isDigit() static method
        System.out.println("Testing the isDigit() static method");
        System.out.println('m' + " is a digit? " + MyCharacter.isDigit('m'));
        System.out.println('N' + " is a digit? " + MyCharacter.isDigit('m'));
        System.out.println('9' + " is a digit? " + MyCharacter.isDigit('9'));
        System.out.println();
        
        // Testing the isLetter() static method
        System.out.println("Testing the isLetter() static method");
        System.out.println('m' + " is a letter? " + MyCharacter.isLetter('m'));
        System.out.println('N' + " is a letter? " + MyCharacter.isLetter('m'));
        System.out.println('9' + " is a letter? " + MyCharacter.isLetter('9'));
        System.out.println();
        
        // Testing the isDigitOrLetter() method
        System.out.println("Testing the isDigitOrLetter() method");
        System.out.println('z' + " is letter or digit? " + MyCharacter.isLetterOrDigit('z'));
        System.out.println('7' + " is letter or digit? " + MyCharacter.isLetterOrDigit('7'));
        System.out.println('/' + " is letter or digit? " + MyCharacter.isLetterOrDigit('/'));
        System.out.println();
        
        // Testing the isLowerCase() method
        System.out.println("Testing the isLowerCase() method");
        System.out.println('z' + " is lower case? " + MyCharacter.isLowerCase('z'));
        System.out.println('Z' + " is lower case? " + MyCharacter.isLowerCase('Z'));
        System.out.println();
        
        // Testing the isUpperCase() method
        System.out.println("Testing the isUpperCase() method");
        System.out.println('z' + " is upper case? " + MyCharacter.isUpperCase('z'));
        System.out.println('Z' + " is upper case? " + MyCharacter.isUpperCase('Z'));
        System.out.println();
        
        // Testing the isWhitespace() method
        System.out.println("Testing the isWhitespace() method");
        System.out.println("The unicode character for TAB is whitespace? " 
                + MyCharacter.isWhitespace('\t'));
        System.out.println("The unicode character for NEW LINE is whitespace? " 
                + MyCharacter.isWhitespace('\n'));
        System.out.println('z' + " is whitespace? " 
                + MyCharacter.isWhitespace('z'));
        System.out.println();
        
        // Testing the toLowerCase() method
        System.out.println("Testing the toLowerCase() method");
        System.out.println("C to lower case is " + MyCharacter.toLowerCase('C'));
        System.out.println("c to lower case is " + MyCharacter.toLowerCase('c'));
        System.out.println();
        
        // Testing the toUpperCase() method
        System.out.println("Testing the toUpperCase() method");
        System.out.println("Z to upper case is " + MyCharacter.toUpperCase('Z'));
        System.out.println("z to upper case is " + MyCharacter.toUpperCase('z'));
        System.out.println();
        
        // Testing the compare() method
        System.out.println("Testing the compare() method");
        System.out.println("Compare z and Z: " 
                + (MyCharacter.compare(new MyCharacter('z'), new MyCharacter('Z'))));
        System.out.println("Compare A and A: " 
                + (MyCharacter.compare(new MyCharacter('A'), new MyCharacter('A'))));
        System.out.println();
        
        // Testing the compareTo() method
        System.out.println("Testing the compareTo() method");
        System.out.println("CompareTo z and Z: " 
                + (new MyCharacter('z').compareTo(new MyCharacter('Z'))));
        System.out.println("CompareTo A and A: " 
                + (new MyCharacter('A').compareTo(new MyCharacter('A'))));
        System.out.println();
    }
}
