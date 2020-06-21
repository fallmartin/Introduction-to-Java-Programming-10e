
/**
 * Output:
 * The BMI for Kim Yang is 20.81 Normal
 * The BMI for Susan King is 30.85 Obese
 * The BMI for Jane Doe is 23.11 Normal
 *
 * @author martinfall
 */
public class TestBMI {

    public static void main(String[] args) {
        BMI bmi1 = new BMI("Kim Yang", 18, 145, 70);
        System.out.println("The BMI for " + bmi1.getName()
                + " is " + bmi1.getBMI() + " " + bmi1.getStatus());

        BMI bmi2 = new BMI("Susan King", 215, 70);
        System.out.println("The BMI for " + bmi2.getName()
                + " is " + bmi2.getBMI() + " " + bmi2.getStatus());

        BMI bmi3 = new BMI("Jane Doe", 38, 180, 6, 2);
        System.out.println("The BMI for " + bmi3.getName()
                + " is " + bmi3.getBMI() + " " + bmi3.getStatus());
    }
}
