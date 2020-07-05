
/**
 *
 * @author martinfall
 */
public class Staff extends Employee {

    // A staff member has a title.
    private String title;

    /**
     * Parameterized constructor of the Staff class.
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param emailAddress
     * @param office
     * @param salary
     * @param title
     */
    public Staff(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary);
        this.title = title;
    }

    // Getter methods
    public String getTitle() {
        return title;
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
