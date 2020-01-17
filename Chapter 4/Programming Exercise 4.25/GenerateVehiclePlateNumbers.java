
/**
 * (Generate vehicle plate numbers) Assume a vehicle plate number consists of
 * three uppercase letters followed by four digits. Write a program to generate a
 * plate number.
 */
/**
 *
 * @author martinfall
 */
public class GenerateVehiclePlateNumbers {

    public static void main(String[] args) {
        String plate = "";

        // Generate three uppercase letters
        for (int i = 0; i < 3; i++) {
            char ch = (char) ((int) (Math.random() * ((90 - 65) + 1)) + 65);
            plate += ch;
        }

        // Generate four digits
        for (int j = 0; j < 4; j++) {
            int num = (int) ((Math.random() * ((9 - 0) + 1)) + 0);
            plate += num;
        }

        // Display the license plate
        System.out.println(plate);
    }
}
