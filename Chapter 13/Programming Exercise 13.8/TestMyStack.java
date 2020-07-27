
/**
 * (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to
 * perform a deep copy of the list field.
 *
 * Output:
 * Creating a new MyStack object...
 * Pushing the numbers 1-10 to the MyStack object...
 * Displaying both stacks to console...
 * stack1: stack: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * stack2: stack: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Pop 3 elements from stack1...
 * Displaying both stacks to console...
 * stack1: stack: [1, 2, 3, 4, 5, 6, 7]
 * stack2: stack: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *
 * @author martinfall
 */
public class TestMyStack {

    public static void main(String[] args) {
        // Create a new MyStack object
        System.out.println("Creating a new MyStack object...");
        MyStack stack1 = new MyStack();

        // Push the numbers 1-10 to the MyStack object
        System.out.println("Pushing the numbers 1-10 to the MyStack object...");
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);

        // Create a new MyStack reference variable
        MyStack stack2 = null;
        try {
            // Create a new MyStack object and assign a clone of MyStrack to its refVar
            stack2 = (MyStack) stack1.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported exception raised.");
        }

        // Display the results
        System.out.println("Displaying both stacks to console...");
        System.out.println("stack1: " + stack1);
        System.out.println("stack2: " + stack2);

        // Pop a few elements from stack1
        System.out.println("Pop 3 elements from stack1...");
        stack1.pop();
        stack1.pop();
        stack1.pop();

        // Display the results
        System.out.println("Displaying both stacks to console...");
        System.out.println("stack1: " + stack1);
        System.out.println("stack2: " + stack2);
    }
}
