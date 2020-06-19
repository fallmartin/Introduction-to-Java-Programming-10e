
/**
 *
 * @author martinfall
 */
public class Course {

    private String courseName; // The name of the course.
    private String[] students = new String[100]; // An array to store the students for the course.
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
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    /**
     * Returns the students for the course.
     *
     * @return
     */
    public String[] getStudents() {
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
        // Left as an exercise in Programming Exercise 10.9
    }
}
