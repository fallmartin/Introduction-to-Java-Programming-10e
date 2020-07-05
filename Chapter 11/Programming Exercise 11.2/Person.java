
/**
 * (The Person, Student, Employee, Faculty, and Staff classes) Design a class
 * named Person and its two subclasses named Student and Employee. Make Faculty
 * and Staff subclasses of Employee.
 *
 * A person has a name, address, phone number, and email address. A student has a
 * class status (freshman, sophomore, junior, or senior). Define the status as a
 * constant. An employee has an office, salary, and date hired. Use the MyDate
 * class defined in Programming Exercise 10.14 to create an object for date hired.
 * A faculty member has office hours and a rank. A staff member has a title.
 * Override the toString method in each class to display the class name and the
 * person’s name.
 *
 * Draw the UML diagram for the classes and implement them. Write a test program
 * that creates a Person, Student, Employee, Faculty, and Staff, and invokes
 * their toString() methods.
 *
 * @author martinfall
 */
public class Person {

    // A person has a name, address, phone number, and email address.
    private String name, address, phoneNumber, emailAddress;

    /**
     * Parameterized constructor of the Person class.
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @param emailAddress
     */
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
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
