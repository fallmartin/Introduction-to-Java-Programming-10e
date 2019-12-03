public class ShowCurrentTime {
    public static void main(String[] args) {
        
        // Obtain the total milliseconds since midnight, January 1, 1970
        // Also known as Unix epoch
        
        //long totalMilliseconds = 1203183068328L; 
        long totalMilliseconds = System.currentTimeMillis();
        
        // Obtain the total seconds totalSeconds by dividing totalMilliseconds by 1000
        long totalSeconds = totalMilliseconds / 1000;
        
        // Compute the current second from totalSeconds % 60
        long currentSecond = totalSeconds % 60;
        
        // Obtain the total minutes totalMinutes by dividing totalSeconds by 60
        long totalMinutes = totalSeconds / 60;
        
        // Compute the current minute from totalMinutes % 60
        long currentMinute = totalMinutes % 60;
        
        // Obtain the total hours totalHours by dividing totalMinutes by 60
        long totalHours = totalMinutes / 60;
        
        // Compute the current hour from totalHours % 24
        long currentHour = totalHours % 24;
        
        System.out.println("Current time is " + currentHour + ":" 
                + currentMinute + ":" + currentSecond + " GMT");
    }
}
