public class Exercise112 {
    public static void main(String[] args) {
        double miles = 24.0;
        double kilometers = miles * 1.609344; 
        double hours = (1.0 + (40.0 / 60) + (35.0 / 3600));
        
        System.out.println(kilometers / hours);
    }
}
