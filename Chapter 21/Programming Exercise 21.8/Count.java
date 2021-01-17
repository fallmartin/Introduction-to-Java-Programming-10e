
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * (Count the occurrences of words in a text file) Rewrite Listing 21.9 to read
 * the text from a text file. The text file is passed as a command-line
 * argument. Words are delimited by whitespace characters, punctuation marks
 * (,;.:?), quotation marks ('"), and parentheses. Count words in
 * case-insensitive fashion (e.g., consider Good and good to be the same word).
 * The words must start with a letter. Display the output in alphabetical order
 * of words, with each word preceded by its occurrence count.
 *
 * Sample Output:
 * ...
 * 1 what
 * 7 when
 * 3 where
 * 5 which
 * 1 whirlwinds
 * 6 white
 * 1 whites
 * 4 who
 * 1 whose
 * 26 will
 * 1 winds
 * 16 with
 * 1 withering
 * 3 words
 * 2 work
 * 2 would
 * 1 wrongful
 * 1 wrote
 * 5 years
 * 1 yes
 * 2 york
 * 8 you
 * 1 your
 *
 * @author martinfall
 */
public class Count {

    static class WordOccurrence implements Comparable<WordOccurrence> {

        String word;
        Integer count;

        public WordOccurrence(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override // Override the compareTo method of the Comparable interface
        public int compareTo(WordOccurrence o) {
            if (word.compareTo(o.word) > 0) {
                return 1;
            } else if (word.compareTo(o.word) == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return count + " " + word;
        }
    }

    public static void main(String[] args) throws IOException {
        // Check command-line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java Count filename.txt");
            System.exit(1);
        }

        // Create a new file from input
        File file = new File(args[0]);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
            System.exit(2);
        }

        // Check if the file is a text file
        if (!file.getName().endsWith(".txt")) {
            System.out.println("The file " + file.getName() + " is not valid.");
            System.out.println("Please enter a txt file.");
            System.exit(3);
        }

        /**
         * If all checks pass, process the file.
         */
        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        // Read the contents of the file into a string and tokenize the words
        String text = Files.readString(Paths.get(file.toURI()));
        String[] words = text.split("[ ,;.:\\?'\"“”‘’()\n—]");

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
