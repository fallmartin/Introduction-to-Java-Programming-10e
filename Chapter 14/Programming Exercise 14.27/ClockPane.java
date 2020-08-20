
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author martinfall
 */
public class ClockPane extends Pane {

    // Variable declarations
    private int hour;
    private int minute;
    private int second;

    // Clock pane's width and height
    private double w = 250, h = 250;

    /**
     * Construct a default clock with the current time.
     */
    public ClockPane() {
        setCurrentTime();
    }

    /**
     * Construct a clock with specified hour, minute, and second.
     *
     * @param hour
     * @param minute
     * @param second
     */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    /**
     * Return hour.
     *
     * @return
     */
    public int getHour() {
        return hour;
    }

    /**
     * Set a new hour.
     *
     * @param hour
     */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /**
     * Return minute.
     *
     * @return
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Set a new minute.
     *
     * @param minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /**
     * Return second.
     *
     * @return
     */
    public int getSecond() {
        return second;
    }

    /**
     * Set a new second.
     *
     * @param second
     */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /**
     * Return clock pane's width.
     *
     * @return
     */
    public double getW() {
        return w;
    }

    /**
     * Set clock pane's width.
     *
     * @param w
     */
    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    /**
     * Return clock pane's height.
     *
     * @return
     */
    public double getH() {
        return h;
    }

    /**
     * Set clock pane's height.
     *
     * @param h
     */
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    /**
     * Set the current time for the clock.
     */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set hours minutes and seconds
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /**
     * Paint the clock.
     */
    protected void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        // Create an array of lines for seconds and hours
        Line[] minMarks = new Line[60]; // Minute markings on the clockface
        Line[] hourMarks = new Line[12]; // Hour markings on the clockface
        Text[] clockFaceHours = new Text[12]; // Hour numbers on the clockface

        // Draw tick marks for minutes
        for (int i = 0; i < 60; i++) {
            // Start (x, y)
            double startX = centerX
                    + clockRadius * Math.cos(2 * Math.PI * i / 60.0);
            double startY = centerY
                    + clockRadius * Math.sin(2 * Math.PI * i / 60.0);
            // End (x, y)
            double endX = centerX
                    + 0.97 * clockRadius * Math.cos(2 * Math.PI * i / 60.0);
            double endY = centerY
                    + 0.97 * clockRadius * Math.sin(2 * Math.PI * i / 60.0);
            // Add the line to the array of minute markings
            minMarks[i] = new Line(startX, startY, endX, endY);
        }

        // Draw tick marks for hours
        for (int i = 0; i < 12; i++) {
            // Start (x, y)
            double startX = centerX
                    + clockRadius * Math.cos(2 * Math.PI * i / 12.0);
            double startY = centerY
                    + clockRadius * Math.sin(2 * Math.PI * i / 12.0);
            // End (x, y)
            double endX = centerX
                    + 0.9 * clockRadius * Math.cos(2 * Math.PI * i / 12.0);
            double endY = centerY
                    + 0.9 * clockRadius * Math.sin(2 * Math.PI * i / 12.0);
            // Add the line to the array of hour markings
            hourMarks[i] = new Line(startX, startY, endX, endY);
        }

        // Update the clock face with hour numbers from 1 to 12
        for (int i = 0; i < 12; i++) {
            // Text position at (x, y)
            double textX = centerX - 5
                    + 0.82 * clockRadius * Math.cos(2 * Math.PI * i / 12.0);
            double textY = centerY + 5
                    + 0.82 * clockRadius * Math.sin(2 * Math.PI * i / 12.0);
            // Add the text to the array of hour numbers
            clockFaceHours[i]
                    = new Text(textX, textY, i <= 9 ? i + 3 + "" : i - 9 + "");
        }

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        // Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        // Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        // Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength
                * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength
                * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength
                * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength
                * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength
                * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength
                * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        // Clear the pane before painting the clock
        getChildren().clear();
        // Add the circle, second, minute, and hour hands to the pane
        getChildren().addAll(circle, sLine, mLine, hLine);

        // Add the minute marks to the clockface
        for (Line minLine : minMarks) {
            getChildren().add(minLine);
        }

        // Add the hour marks to the clockface
        for (Line hourLine : hourMarks) {
            getChildren().add(hourLine);
        }

        // Add the numbers 1 to 12 to the clockface
        for (Text hour : clockFaceHours) {
            getChildren().add(hour);
        }
    }
}
