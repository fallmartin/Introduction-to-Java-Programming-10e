
import java.util.*;

/**
 * (Use Comparator) Write the following generic method using selection sort and
 * a comparator.
 *
 * public static <E> void selectionSort(E[] list,
 * Comparator<? super E> comparator)
 *
 * Write a test program that creates an array of 10 GeometricObjects and invokes
 * this method using the GeometricObjectComparator introduced in Listing 20.4 to
 * sort the elements. Display the sorted elements. Use the following statement
 * to create the array.
 *
 * @author martinfall
 */
public class UseComparator {

    public static void main(String[] args) {
        GeometricObject[] list = {
            new Circle(5),
            new Rectangle(4, 5),
            new Circle(5.5),
            new Rectangle(2.4, 5),
            new Circle(0.5),
            new Rectangle(4, 65),
            new Circle(4.5),
            new Rectangle(4.4, 1),
            new Circle(6.5),
            new Rectangle(4, 5)
        };

        System.out.println("Before sorting...\n");
        printList(list);

        GeometricObjectComparator comparator = new GeometricObjectComparator();
        selectionSort(list, comparator);

        System.out.println("\nAfter sorting...\n");
        printList(list);
    }

    public static void printList(GeometricObject[] list) {
        for (var v : list) {
            System.out.println(v.getClass().getName() + " " + v.getArea());
        }
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            E min = list[i];
            int minIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                E curr = list[j];
                if (comparator.compare(min, curr) == -1) {
                    min = curr;
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                E e = list[i];
                list[i] = min;
                list[minIndex] = e;
            }
        }
    }
}
