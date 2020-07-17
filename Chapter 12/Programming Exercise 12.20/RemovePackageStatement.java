
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Remove package statement) Suppose you have Java source files under the
 * directories chapter1, chapter2, . . . , chapter34. Write a program to
 * remove the statement package chapteri; in the first line for each Java
 * source file under the directory chapteri. Suppose chapter1, chapter2,
 * . . . , chapter34 are under the root directory srcRootDirectory. The root
 * directory and chapteri directory may contain other folders and files. Use
 * the following command to run the program:
 *
 * java Exercise12_20 srcRootDirectory
 *
 * @author martinfall
 */
public class RemovePackageStatement {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Generate directory structure...");
        try {
            // Generate directory structure
            createDirectoryStructure(args);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        // Create a new File object hosting the root directory
        File root = new File(args[0]);

        // Create FilenameFilter filters for folders and java source files
        // https://www.tutorialspoint.com/java/io/file_listfiles_filename_filter.htm
        FilenameFilter filterFolders = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains("chapter")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        FilenameFilter filterSourceFiles = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Create an array of File objects containing the chapter folders
        File[] listOfFolders = root.listFiles(filterFolders);

        // Loop through each folder
        for (File folder : listOfFolders) {
            File[] listOfFiles = folder.listFiles(filterSourceFiles);
            for (File sourceFile : listOfFiles) {
                String str = "";
                try ( // Create input file
                        Scanner input = new Scanner(sourceFile);) {
                    while (input.hasNext()) {
                        String line = input.nextLine();
                        if (!line.contains("package chapter")) {
                            str += line + "\n";
                        }
                    }
                }
                // Uncomment the line below to see the changes in the terminal
                // System.out.println(str);
                
                try(// Create output file
                        PrintWriter output = new PrintWriter(sourceFile);) {
                    output.print(str);
                }
            }
        }
    }

    /**
     * Create directory structure with root dir, corresponding child dirs, and
     * source files without the package statement.
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void createDirectoryStructure(String[] args)
            throws FileNotFoundException {
        // Local variables
        final int NUMBER_OF_CHAPTERS = 34;

        // Check command line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java AddPackageStatement srcRootDirectory");
            System.exit(1);
        }

        // Create a root directory object
        File root = new File(args[0]);

        // Check if the root directory exists and create it if not
        if (!root.exists()) {
            // System.out.println("Directory " + root.getName() + " not found");
            // System.exit(2);
            // Create a new root directory
            root.mkdir();
            // System.out.println("Root directory " + root.getName() + " created");
        }

        // Check if the directories insire the root exist and create them if not
        for (int i = 0; i < NUMBER_OF_CHAPTERS; i++) {
            File tmp = new File(root.getPath(), "chapter" + (i + 1));
            if (!tmp.exists()) {
                // System.out.println("Directory " + tmp.getName() + " not found");
                tmp.mkdir();
                // System.out.println("Directory " + tmp.getName() + " created");

                // Create Java source file are under the directory chapteri
                File sourceFile = new File(tmp.getPath(), "sourceFile" + (i + 1) + ".java");

                // Add code to source file
                try (PrintWriter output = new PrintWriter(sourceFile);) {
                    //output.println("/**");
                    //output.println(" *");
                    //output.println(" * @author martinfall");
                    //output.println(" */");
                    output.println("package chapter" + (i + 1) + ";\n\n");
                    output.println("public class sourceFile" + (i + 1) + " {");
                    output.println("    public static void main(String[] args) {");
                    output.println("        // Test source file");
                    output.println("    }");
                    output.println("}");
                }
            }
        }

        System.out.println("Directory structure successfully generated.");
    }
}
