
import java.io.File;
import java.util.Date;

/**
 * Output:
 * Does it exist? false
 * The file has 0 bytes
 * Can it be read? false
 * Can it be written? false
 * Is it a directory? false
 * Is it a file? false
 * Is it absolute? false
 * Is it hidden? false
 * Absolute path is
 * /Users/martinfall/NetBeansProjects/Listing_12_12/image/us.gif
 * Last modified on Wed Dec 31 19:00:00 EST 1969
 *
 * @author martinfall
 */
public class TestFileClass {

    public static void main(String[] args) {
        File file = new File("image/us.gif");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is " + file.getAbsolutePath());
        System.out.println("Last modified on " + new Date(file.lastModified()));
    }
}
