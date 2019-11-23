public class ComputerArea {
    public static void main(String[] args) {
        double radius; // Declare radius
        double area; // Declare area
        
        // Assign a radius
        radius = 20; // radius is now 20
        
        // Step 1: Read in radius
        
        // Step 2: Compute the area
        area = Math.pow(radius, 2) * Math.PI;
        
        // Step 3: Display the area
        System.out.println("The area for the circle of radius " +
                radius + " is " + area);
    }
}
