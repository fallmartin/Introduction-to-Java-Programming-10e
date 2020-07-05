
/**
 * Write a test program that creates a Person, Student, Employee, Faculty, and
 * Staff, and invokes their toString() methods.
 *
 * Output:
 * Class: Person
 * Name: John Smith
 *
 * Class: Student
 * Name: Frasier Crane
 *
 * Class: Employee
 * Name: Bob Belcher
 *
 * Class: Faculty
 * Name: Niles Crane
 *
 * Class: Staff
 * Name: Jane Smith
 *
 * @author martinfall
 */
public class TestPE_11_2 {

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John Smith", "Washington, DC", "867-5309",
                "johnsmith@gmail.com");
        System.out.println(person.toString());
        System.out.println();

        // Create a Student object
        Student student = new Student("Frasier Crane", "Seattle", "867-5309",
                "frasier@kacl.com", 1);
        System.out.println(student.toString());
        System.out.println();

        // Create an Employee object
        Employee employee = new Employee("Bob Belcher", "Bob's Burgers", "IDK",
                "None", "Office 123", 25000.00);
        System.out.println(employee.toString());
        System.out.println();

        // Create a Faculty object
        Faculty faculty = new Faculty("Niles Crane", "Private St", "1234567890",
                "niles@yahoo.com", "Room 7", 50000.00, "Office Hours", "#1");
        System.out.println(faculty.toString());
        System.out.println();

        // Create a Staff object
        Staff staff = new Staff("Jane Smith", "Address", "9876543210",
                "jane@aol.com", "Room 7", 70000.00, "Professor");
        System.out.println(staff.toString());
    }
}
