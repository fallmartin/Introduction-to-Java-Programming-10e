
/**
 * (Enable the Course class cloneable) Rewrite the Course class in Listing 10.6
 * to add a clone method to perform a deep copy on the students field.
 *
 */
/**
 * (The Course class) Revise the Course class as follows:
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
public class Course implements Cloneable {

    private final int DEFAULT_CAPACITY = 100;
    private String courseName;
    private String[] students = new String[DEFAULT_CAPACITY];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Add a student to the course.
     *
     * @param student
     */
    public void addStudent(String student) {
        if (students.length == numberOfStudents) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Getters
    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    /**
     * Removes a student from the course.
     *
     * @param student
     */
    public void dropStudent(String student) {
        int index = -1;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == student) {
                index = i;
            }
        }
        // System.out.println("Index is " + index);

        if (index >= 0) {
            for (int i = index; i < students.length - 1; i++) {
                students[i] = students[i + 1];
            }
        }
        numberOfStudents--;
    }

    /**
     * Removes all students from the course.
     */
    public void clear() {
        students = new String[DEFAULT_CAPACITY];
        numberOfStudents = 0;
    }

    @Override // Overrides the clone method defined in the Object class
    public Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        Course clonedCourse = (Course) super.clone();
        // Perform a deep copy on the students field
        clonedCourse.students = students.clone();
        // Return the cloned Course
        return clonedCourse;
    }

}
