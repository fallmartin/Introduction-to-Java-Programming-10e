public class Exercise111 {
    public static void main(String[] args) {
        double current_population = 312032486;
        double year = 365;
        
        double birth = (year * 24 * 60 * 60) / 7;
        double death = (year * 24 * 60 * 60) / 13;
        double immigrants = (year * 24 * 60 * 60) / 45;
        
        double yearly_increase = birth + immigrants - 
                death;
        
        for (int i = 0; i <= 5; i++) {
            System.out.print("Year " + i + ": ");
            System.out.println(String.format("%.2f", current_population));
            //System.out.println(current_population);
            current_population += yearly_increase;
        }
    }
}
