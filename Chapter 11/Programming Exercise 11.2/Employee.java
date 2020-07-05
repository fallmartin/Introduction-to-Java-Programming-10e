
/**
 *
 * @author martinfall
 */
public class Employee extends Person {

    // An employee has an office, salary, and date hired. Use the MyDate class 
    // defined in Programming Exercise 10.14 to create an object for date hired
    private String office;
    private double salary;
    private MyDate dateHired;

    /**
     * Parameterized constructor of the Employee class.
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param emailAddress
     * @param office
     * @param salary
     */
    public Employee(String name, String address, String phoneNumber, String emailAddress,
            String office, double salary) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = new MyDate();
    }

    // Getter methods
    public String getOffice() {
        return office;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getDateHired() {
        return dateHired;
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
