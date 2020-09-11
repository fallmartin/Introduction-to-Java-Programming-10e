
/**
 * (Simulation: self-avoiding random walk) Write a simulation program to show
 * that the chance of getting dead-end paths increases as the grid size
 * increases. Your program simulates lattices with size from 10 to 80. For each
 * lattice size, simulate a self-avoiding random walk 10,000 times and display
 * the probability of the dead-end paths, as shown in the following sample
 * output:
 *
 * For a lattice of size 10, the probability of dead-end paths is 10.6%
 * For a lattice of size 11, the probability of dead-end paths is 14.0%
 * ...
 * For a lattice of size 80, the probability of dead-end paths is 99.5%
 *
 * Sample output:
 *
 * For a lattice of size 10, the probability of dead-end paths is 6.69%
 * For a lattice of size 20, the probability of dead-end paths is 36.03%
 * For a lattice of size 30, the probability of dead-end paths is 61.42%
 * For a lattice of size 40, the probability of dead-end paths is 78.39%
 * For a lattice of size 50, the probability of dead-end paths is 88.00%
 * For a lattice of size 60, the probability of dead-end paths is 93.57%
 * For a lattice of size 70, the probability of dead-end paths is 96.67%
 * For a lattice of size 80, the probability of dead-end paths is 98.50%
 *
 * @author martinfall
 */
public class SelfAvoidingRandomWalk {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new lattice

        // Testing, testing
        for (int i = 10; i <= 80; i += 10) {
            Lattice lattice = new Lattice(i);
            lattice.getDeadEndPathProbability();
        }

    }
}
