
/**
 *
 * @author martinfall
 */
public class BeanMachine {

    private int balls;
    private int slots;
    private int[][] paths;

    /**
     * No args constructor for the BeanMachine class.
     */
    public BeanMachine() {
        this(10, 8); // 10 balls and 8 slots - Default
    }

    /**
     * Private constructor for a BeanMachine object with balls and slots
     * parameters.
     *
     * @param balls
     * @param slots
     */
    private BeanMachine(int balls, int slots) {
        this.balls = balls;
        this.slots = slots;
        generatePaths(); // Populates paths with 0s and 1s randomly
    }

    /**
     * Randomly populates a 2D array where each row represents a ball and each
     * column is 0L or 1R.
     *
     * @return
     */
    private void generatePaths() {
        paths = new int[balls][slots - 1];

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                paths[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    /**
     * Returns a 2D array of paths for each ball, where each row represents a
     * ball and each column is 0L or 1R.
     *
     * @return
     */
    public int[][] getPaths() {
        return paths;
    }

    /**
     * Returns the number of balls.
     *
     * @return
     */
    public int getBalls() {
        return balls;
    }

    /**
     * Sets the number of balls;
     *
     * @param balls
     */
    public void setBalls(int balls) {
        this.balls = balls;
    }

    /**
     * Returns the number of slots.
     *
     * @return
     */
    public int getSlots() {
        return slots;
    }

    /**
     * Sets the number of slots.
     *
     * @param slots
     */
    public void setSlots(int slots) {
        this.slots = slots;
    }

}
