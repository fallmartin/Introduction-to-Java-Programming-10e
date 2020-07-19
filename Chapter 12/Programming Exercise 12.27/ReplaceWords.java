
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * (Replace words) Suppose you have a lot of files in a directory that contain
 * words Exercisei_j, where i and j are digits. Write a program that pads a 0
 * before i if i is a single digit and 0 before j if j is a single digit. For
 * example, the word Exercise2_1 in a file will be replaced by Exercise02_01.
 * In Java, when you pass the symbol * from the command line, it refers to all
 * files in the directory (see Supplement III.V). Use the following command to
 * run your program.
 *
 * java Exercise12_27 *
 *
 *
 * @author martinfall
 */
public class ReplaceWords {

    /**
     * Main method.
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        // Check command line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java ReplaceWords \\*");
            System.exit(1);
        }

        // Generate the file structure needed for the exercise.
        generateFileStructure();

        // Create a new File object for target dir
        File dir = new File("dir");

        // Check if the directory exists
        if (!dir.exists() && !dir.isDirectory()) {
            System.out.println("The directory doesn't exist.");
            System.exit(1);
        }

        // Create a File array for the contents of dir
        File[] files = dir.listFiles();

        // Loop through the files in the array
        for (File f : files) {
            // Assign the filename to a string
            String fileName = f.getName();
            // System.out.println(fileName);
            // Create an array of strings to hold chapter and exercise numbers
            String[] str = getChapterAndExercise(fileName).split("_");
            String chapter = str[0];
            String exercise = str[1];

            // If the chapter is i, make it 0i
            if (chapter.length() == 1) {
                chapter = "0" + chapter;
            }
            // If the exercise is j, make it 0j
            if (exercise.length() == 1) {
                exercise = "0" + exercise;
            }

            try (PrintWriter output = new PrintWriter(f);) {
                String renamedStr = "Exercise" + chapter + "_" + exercise;
                File file = new File(dir, renamedStr);
                f.renameTo(file);
            }
        }
        System.out.println("Files renamed successfully");
    }

    /**
     * Generate the file structure needed for the exercise.
     *
     * @throws FileNotFoundException
     */
    public static void generateFileStructure() throws FileNotFoundException, IOException {
        // Number of files to be generated
        final int NUMBER_OF_CHAPTERS = 34;
        final int NUMBER_OF_EXERCISES = 25;

        // Create a File object for our directory
        File dir = new File("dir");

        // Check if it exists
        if (dir.mkdirs()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory already exists");
        }

        // Populate the dir with random files conventionally named as needed
        for (int i = 1; i <= NUMBER_OF_CHAPTERS; i++) {
            for (int j = 1; j <= NUMBER_OF_EXERCISES; j++) {
                // Build a string with i and j
                String str = "Exercise" + i + "_" + j + ".txt";

                // Create a new File object
                File file = new File(dir, str);
                // System.out.println(file.getCanonicalPath());

                try (PrintWriter output = new PrintWriter(file);) {
                    // Variable output is not used
                    // Nothing needed here since we're only modifying names
                }
            }
        }
    }

    public static String getChapterAndExercise(String fileName) {
        return fileName.substring(fileName.lastIndexOf('e') + 1, fileName.length());
    }
}
