
import java.util.ArrayList;

/**
 * (The Course class) Rewrite the Course class in Listing 10.6. Use an ArrayList
 * to replace an array to store students. Draw the new UML diagram for the
 * class. You should not change the original contract of the Course class (i.e.,
 * the definition of the constructors and methods should not be changed, but the
 * private members may be changed.)
 *
 * @author martinfall
 */
public class Course {

    private String courseName; // The name of the course.
    // An ArrayList to store the students for the course.
    // private String[] students = new String[100]; 
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents; // The number of students (default: 0).

    /**
     * Creates a course with the specified name.
     *
     * @param courseName
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Adds a new student to the course.
     *
     * @param student
     */
    public void addStudent(String student) {
        // students[numberOfStudents] = student;
        this.students.add(student);
        numberOfStudents++;
    }

    /**
     * Returns the students for the course.
     *
     * @return
     */
    public ArrayList<String> getStudents() {
        return students;
    }

    /**
     * Returns the number of students for the course.
     *
     * @return
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Returns the course name.
     *
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Drops a student from the course.
     *
     * @param student
     */
    public void dropStudent(String student) {
        // this.students.remove(student);
        students.remove(students.indexOf(student));
        numberOfStudents--;
    }
    
    /**
     * Removes all students from the course.
     */
    public void clear() {
        students.clear();
    }
}
