
import java.util.*;

/**
 * (Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to
 * display the words in ascending order of occurrence counts. (Hint: Create a
 * class named WordOccurrence that implements the Comparable interface. The
 * class contains two fields, word and count. The compareTo method compares the
 * counts. For each pair in the hash set in Listing 21.9, create an instance of
 * WordOccurrence and store it in an array list. Sort the array list using the
 * Collections.sort method. What would be wrong if you stored the instances of
 * WordOccurrence in a tree set?)
 *
 * The sort method of the Collections class sorts lists only. Therefore, we
 * cannot store the instances of WordOccurrence in a tree set if we want to use
 * the Collections.sort method to order our data structure in ascending order of
 * occurrence counts.
 * Output:
 *
 * class 1
 * fun 1
 * morning 1
 * visit 1
 * a 2
 * good 3
 * have 3
 *
 * @author martinfall
 */
public class CountOccurrenceOfWords {

    static class WordOccurrence implements Comparable<WordOccurrence> {

        String word;
        Integer count;

        public WordOccurrence(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override // Override the compareTo method of the Comparable interface
        public int compareTo(WordOccurrence o) {
            if (count > o.count) {
                return 1;
            } else if (count == o.count) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return word + " " + count;
        }
    }

    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. "
                + "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[ \n\t\r.,;:!?(){}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        // Create an array list for WordOccurence objects
        ArrayList<WordOccurrence> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            String word = (String) entry.getKey();
            Integer count = (Integer) entry.getValue();
            WordOccurrence wo = new WordOccurrence(word, count);
            list.add(wo); // Add word occurrences to the list
        }

        Collections.sort(list); // Sort the list
        list.forEach(wo -> System.out.println(wo)); // Print to console
    }
}
