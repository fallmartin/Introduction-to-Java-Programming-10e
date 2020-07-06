
import java.util.ArrayList;
import java.util.Date;

/**
 * (Use ArrayList) Write a program that creates an ArrayList and adds a Loan
 * object, a Date object, a string, and a Circle object to the list, and use a
 * loop
 * to display all the elements in the list by invoking the object’s toString()
 * method.
 *
 * Output:
 * I am a Loan object.
 * Sun Jul 05 23:58:21 EDT 2020
 * I am a String object
 * I am a Circle object.
 *
 * @author martinfall
 */
public class ListWithObjectsFromDifferentClasses {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create Loan, Date, String, Circle objects
        Loan loan = new Loan();
        Date date = new Date();
        String string = "I am a String object";
        Circle circle = new Circle();

        // Add the object to an ArrayList
        ArrayList<Object> list = new ArrayList<>();
        list.add(loan);
        list.add(date);
        list.add(string);
        list.add(circle);

        // Use a loop to display all the elements in the list by invoking the
        // object's toString() method
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }
}

class Loan {

    public Loan() {
    }

    @Override
    public String toString() {
        return "I am a Loan object.";
    }

}

class Circle {

    public Circle() {

    }

    @Override
    public String toString() {
        return "I am a Circle object.";
    }
}
