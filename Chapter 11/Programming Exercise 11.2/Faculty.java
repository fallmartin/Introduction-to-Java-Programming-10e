
/**
 *
 * @author martinfall
 */
public class Faculty extends Employee {

    // A faculty member has office hours and a rank.
    private String officeHours;
    private String rank;

    /**
     * Parameterized constructor of the Faculty class.
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param emailAddress
     * @param office
     * @param salary
     * @param officeHours
     * @param rank
     */
    public Faculty(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    // Getter methods
    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    /**
     * Override the toString method in each class to display the class name and
     * the person’s name.
     */
    @Override
    public String toString() {
        return "Class: " + this.getClass().getCanonicalName() + "\nName: " + this.getName();
    }
}
