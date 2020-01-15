
/**
 * 4.16 (Random character) Write a program that displays a random uppercase
 * letter using the Math.random() method.
 */

/**
 *
 * @author martinfall
 */
public class RandomCharacter {

    public static void main(String[] args) {
        //System.out.println((int) 'A');
        //System.out.println((int) 'Z');

        //(max - min) + 1) + min
        int number = (int) (Math.random() * 26) + 65;
        System.out.println("int value: " + number);
        System.out.println("Converted char value: " + (char) number);
    }
}
