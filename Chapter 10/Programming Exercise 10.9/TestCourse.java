
/**
 *(The Course class) Revise the Course class as follows:
 *
 * ■ The array size is fixed in Listing 10.6. Improve it to automatically increase
 * the array size by creating a new larger array and copying the contents of the
 * current array to it.
 * ■ Implement the dropStudent method.
 * ■ Add a new method named clear() that removes all students from the
 * course.
 *
 * Write a test program that creates a course, adds three students, removes one,
 * and displays the students in the course.
 *
 * @author martinfall
 */
public class TestCourse {

    public static void main(String[] args) {
        // Creating a course
        Course course = new Course("Introduction to Java");

        // Adding three students
        course.addStudent("John Doe");
        course.addStudent("John Smith");
        course.addStudent("Jane Doe");

        // Remove one student
        course.dropStudent("Jane Smith");

        // Display the students in the course
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }
    }
}
