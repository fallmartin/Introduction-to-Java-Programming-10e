
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author martinfall
 */
public class ObservablePropertyDemo {

    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();

        /**
         * Adds an InvalidationListener which will be notified whenever the
         * Observable becomes invalid. If the same listener is added more than
         * once, then it will be notified more than once. That is, no check is
         * made to ensure uniqueness.
         *
         * Note that the same actual InvalidationListener instance may be safely
         * registered for different Observables.
         */
        balance.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable ov) {
                System.out.println("The new value is "
                        + balance.doubleValue());
            }
        });

        balance.addListener(ov -> System.out.println("The new value is "
                + balance.doubleValue()));

        balance.set(4.5);
    }
}
