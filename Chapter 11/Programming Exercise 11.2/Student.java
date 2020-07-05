
/**
 *
 * @author martinfall
 */
public class Student extends Person {

    // A student has a class status (freshman, sophomore, junior, or senior). 
    // Define the status as a constant.
    private int classStatus;

    private static final int FRESHMAN = 0;
    private static final int SOPHOMORE = 1;
    private static final int JUNIOR = 2;
    private static final int SENIOR = 3;

    /**
     * Parameterized constructor of the Student class.
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param emailAddress
     * @param classStatus
     */
    public Student(String name, String address, String phoneNumber,
            String emailAddress, int classStatus) {
        super(name, address, phoneNumber, emailAddress);
        this.classStatus = classStatus;
    }

    // Getter methods
    public int getClassStatus() {
        return classStatus;
    }

    /**
     * Override the toString method in each class to display the class name and
     * the person’s name.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Class: " + this.getClass().getCanonicalName() + "\nName: " + this.getName();
    }
}
