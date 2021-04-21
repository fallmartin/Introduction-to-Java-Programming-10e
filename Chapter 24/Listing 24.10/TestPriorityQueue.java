package mypriorityqueue;

/**
 * Listing 24.10 gives an example of using a priority queue for patients.
 *
 * Output:
 * Cindy(priority:7) Tim(priority:5) John(priority:2) Jim(priority:1)
 *
 * @author martinfall
 */
public class TestPriorityQueue {

    /**
     * Main method with driver code to test the MyPriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create four patients with varying priorities
        Patient patient1 = new Patient("John", 2);
        Patient patient2 = new Patient("Jim", 1);
        Patient patient3 = new Patient("Tim", 5);
        Patient patient4 = new Patient("Cindy", 7);

        MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);

        while (priorityQueue.getSize() > 0) {
            System.out.print(priorityQueue.dequeue() + " ");
        }
    }

    /**
     * Inner class Patient.
     */
    static class Patient implements Comparable<Patient> {

        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override // Override the toString method of the Object class
        public String toString() {
            return name + "(priority:" + priority + ")";
        }

        @Override // Override the compareTo method of the Comparable interface
        public int compareTo(Patient patient) {
            return this.priority - patient.priority;
        }
    }

}
