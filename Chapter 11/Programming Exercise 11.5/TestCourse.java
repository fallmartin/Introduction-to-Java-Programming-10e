
/**
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
        // Display the students in the course
        System.out.println(course.getStudents());

        // Remove one student
        System.out.println("Removing John Smith");
        course.dropStudent("John Smith");

        // Display the students in the course
        System.out.println(course.getStudents());
    }
}
