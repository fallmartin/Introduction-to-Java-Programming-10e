
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * (Display a calendar) Write a program that displays the calendar for the
 * current month. You can use the Prior and Next buttons to show the calendar of
 * the previous or next month. Display the dates in the current month in black
 * and display the dates in the previous month and next month in gray, as shown
 * in Figure 16.48.
 *
 * @author martinfall
 */
public class DisplayCalendar extends Application {

    // Width and height data fields
    private static final double WIDTH = 720;
    private static final double HEIGHT = 300;

    // Create a new Gregorian calendar
    Calendar calendar = new GregorianCalendar(Locale.US);

    // Create a label
    Label lblMonthYear = new Label();

    // Create a new border pane
    BorderPane pane = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set the label on start with current month
        lblMonthYear.setText(getMonthYearString());
        lblMonthYear.setPadding(new Insets(10));
        lblMonthYear.setAlignment(Pos.CENTER);

        // Create a new calendar body pane
        GridPane paneForCalendarBody = createCalendarForMonth();

        // Create the prior and next buttons and add them to a new HBox 
        Button btPrior = new Button("Prior");
        Button btNext = new Button("Next");
        HBox paneForButtons = new HBox(10);
        paneForButtons.setPadding(new Insets(10));
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.getChildren().addAll(btPrior, btNext);

        // Add the label, calendar display, and buttons to the pane
        pane.setTop(lblMonthYear);
        pane.setCenter(paneForCalendarBody);
        pane.setBottom(paneForButtons);

        // Set the width and height properties of the border pane
        BorderPane.setAlignment(lblMonthYear, Pos.CENTER);
        BorderPane.setAlignment(paneForButtons, Pos.CENTER);

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("DisplayCalendar"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable

        // Event handlers for the buttons
        btPrior.setOnAction(e -> {
            calendar.add(Calendar.MONTH, -1);
            lblMonthYear.setText(getMonthYearString());
            pane.setCenter(createCalendarForMonth());
        });

        btNext.setOnAction(e -> {
            calendar.add(Calendar.MONTH, 1);
            lblMonthYear.setText(getMonthYearString());
            pane.setCenter(createCalendarForMonth());
        });
    }

    /**
     * Returns a calendar pane for the current month.
     *
     * @return
     */
    public GridPane createCalendarForMonth() {

        // Create a new grid pane for the calendar body
        GridPane paneForCalendarBody = new GridPane();

        // Set the properties of the grid pane as needed
        paneForCalendarBody.setAlignment(Pos.CENTER);
        paneForCalendarBody.setPadding(new Insets(10));
        paneForCalendarBody.setHgap(10);
        paneForCalendarBody.setVgap(10);

        // Establish column constraints to maintain uniformity
        ColumnConstraints[] ccs = new ColumnConstraints[7]; // 7 columns
        for (ColumnConstraints cc : ccs) {
            cc = new ColumnConstraints(75);
            paneForCalendarBody.getColumnConstraints().add(cc);
        }

        /**
         * Display the days of the week in the first row.
         */
        // Create the days of the week grid pane from an array of strings
        String[] daysOfTheWeek = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };

        // Add the days of the week to the first row
        for (String day : daysOfTheWeek) {
            paneForCalendarBody.addRow(0, new Label(day));
        }

        /**
         * Obtain the number of days in the previous month.
         */
        // Get the number of days in the previous month
        Calendar prevCalendar = (GregorianCalendar) calendar.clone();
        prevCalendar.add(Calendar.MONTH, -1);
        int numberOfDaysInPrevMonth
                = prevCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        /**
         * Obtain the number of days in and the first day of the current month.
         */
        // Get the number of days in the current month
        int numberOfDaysInMonth
                = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Set the date to the first day of the month
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // Get the first day of the month (Sunday is 1, Monday is 2, ...)
        int firstWeekDayInMonth = calendar.get(Calendar.DAY_OF_WEEK);

        /**
         * Print the current month's calendar body, including previous and
         * following month's visible days.
         */
        int rowIndex = 1; // Second row starts the dates of the month
        int columnIndex = firstWeekDayInMonth - 1; // Days are 1-7
        int dayCounter = 1; // Day counter for the current month loop

        // Fill the space before the first day of the month
        int prevColumnIndex = 0;
        int prevMonthVisibleDate = numberOfDaysInPrevMonth - columnIndex + 1;

        while (prevColumnIndex < columnIndex) {
            Label lblDate = new Label(Integer.toString(prevMonthVisibleDate));
            lblDate.setTextFill(Color.LIGHTGRAY);
            paneForCalendarBody.add(lblDate, prevColumnIndex, rowIndex);
            prevColumnIndex++; // Increment the column counter for previous month
            prevMonthVisibleDate++; // Increment the prev month visible date
        }

        // Fill the current month's calendar body
        // While the day counter is less than or equal to the number of days
        while (dayCounter <= numberOfDaysInMonth) {
            // Add the day to the corresponding row and column
            paneForCalendarBody.add(new Label(Integer.toString(dayCounter)),
                    columnIndex, rowIndex);

            // Update the row and column indices
            if (columnIndex % 6 == 0 && columnIndex != 0) {
                rowIndex++;
                columnIndex = 0;

            } else {
                columnIndex++;
            }
            dayCounter++; // Increment the day counter
        }

        // Fill the space after the first day of the month
        int nextColumnIndex = columnIndex;
        int nextMonthVisibleDate = 1;

        if (columnIndex != 0) {
            while (columnIndex <= 6) {
                Label lblDate = new Label(Integer.toString(nextMonthVisibleDate));
                lblDate.setTextFill(Color.LIGHTGRAY);
                paneForCalendarBody.add(lblDate, columnIndex, rowIndex);
                columnIndex++; // Increment the column counter for next month
                nextMonthVisibleDate++; // Increment the next month visible date
            }
        }

        return paneForCalendarBody;
    }

    private String getMonthYearString() {
        return new DateFormatSymbols().getMonths()[calendar.get(Calendar.MONTH)]
                + ", " + calendar.get(Calendar.YEAR);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
