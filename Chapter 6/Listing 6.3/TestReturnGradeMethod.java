
/**
 * The grade is C
 * The grade is F
 */
/**
 *
 * @author martinfall
 */
public class TestReturnGradeMethod {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The grade is " + getGrade(78.5));
        System.out.println("The grade is " + getGrade(59.5));
    }

    /**
     * Print the corresponding grade
     *
     * @param score
     * @return
     */
    public static char getGrade(double score) {
        if (score >= 90.0) {
            return 'A';
        } else if (score >= 80.0) {
            return 'B';
        } else if (score >= 70.0) {
            return 'C';
        } else if (score >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
