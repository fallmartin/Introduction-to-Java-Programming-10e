
import java.util.*;

/**
 * Output:
 * Display entries in HashMap
 * {Lewis=29, Smith=30, Cook=29, Anderson=31}
 *
 * Display entries in ascending order of key
 * {Anderson=31, Cook=29, Lewis=29, Smith=30}
 *
 * The age for Lewis is 29
 * Display entries in LinkedHashMap
 * {Smith=30, Anderson=31, Cook=29, Lewis=29}
 *
 * @author martinfall
 */
public class TestMap {

    public static void main(String[] args) {
        // Create a hash map
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        // Create a tree map from the preceding hash map
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        // Create a linked hash map
        Map<String, Integer> linkedHashMap
                = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        // Display the age for Lewis
        System.out.println("\nThe age for Lewis is "
                + linkedHashMap.get("Lewis"));

        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);
    }
}
