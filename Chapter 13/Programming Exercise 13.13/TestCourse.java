
import java.util.Arrays;


/**
 * (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6
 * to add a clone method to perform a deep copy on the students field.
 *
 * @author martinfall
 */
public class TestCourse {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create a new String literal with course name
        String courseName = "Introduction to Java";
        
        // Create a new Course object
        Course course = new Course(courseName);
        
        // Add a four students to course
        course.addStudent("Frasier Crane");
        course.addStudent("Niles Crane");
        course.addStudent("Daphne Moon");
        course.addStudent("Roz Doyle");
        course.addStudent("Martin Crane");
        
        // Clone the course and assign it to a new Course object
        Course clonedCourse = (Course) course.clone();
        
        // Add two more names to the newly cloned list
        clonedCourse.addStudent("Eddie");
        clonedCourse.addStudent("Bob \'Bulldog\' Briscoe");
        
        // Display both Course objects
        System.out.println(Arrays.toString(course.getStudents()));
        System.out.println(Arrays.toString(clonedCourse.getStudents()));
    }
}
