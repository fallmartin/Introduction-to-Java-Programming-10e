
import java.io.*;

/**
 * (BitOutputStream) Implement a class named BitOutputStream, as shown in Figure
 * 17.22, for writing bits to an output stream. The writeBit(char bit) method
 * stores the bit in a byte variable. When you create a BitOutputStream, the
 * byte is empty. After invoking writeBit('1'), the byte becomes 00000001. After
 * invoking writeBit("0101"), the byte becomes 00010101. The first three bits
 * are not filled yet. When a byte is full, it is sent to the output stream. Now
 * the byte is reset to empty. You must close the stream by invoking the close()
 * method. If the byte is neither empty nor full, the close() method first fills
 * the zeros to make a full 8 bits in the byte, and then outputs the byte and
 * closes the stream. For a hint, see Programming Exercise 5.44. Write a test
 * program that sends the bits 010000100100001001101 to the file named
 * Exercise17_17.dat.
 *
 * Output: 01000010 01000010 01101000 // 66 66 104
 *
 * +BitOutputStream(file: File)
 * +writeBit(char bit): void
 * +writeBit(String bit): void
 * +close(): void
 *
 * Creates a BitOutputStream to writes bits to the file.
 * Writes a bit '0' or '1' to the output stream.
 * Writes a string of bits to the output stream.
 * This method must be invoked to close the stream.
 *
 * @author martinfall
 */
public class BitOutputStream implements AutoCloseable {

    // Data fields
    FileOutputStream output;
    byte b;
    int bitCounter;

    /**
     * Creates a BitOutputStream to writes bits to the file.
     *
     * @param file
     * @throws java.io.FileNotFoundException
     */
    public BitOutputStream(File file) throws FileNotFoundException {
        // Initializers in constructor
        this.output = new FileOutputStream(file);
        this.b = 0;
        this.bitCounter = 0;
    }

    /**
     * Writes a bit '0' or '1' to the output stream.
     *
     * @param bit
     * @throws java.io.IOException
     */
    public void writeBit(char bit) throws IOException {
        // Bit shift to the left by 1
        b = (byte) (b << 1);

        // Update the least significant bit if bit is equal to 1
        // If bit is equal to 0, the left shit is all that is needed
        if (bit == '1') {
            b = (byte) (b | 1);
        }

        // Update the bit counter
        bitCounter++;

        // Output the byte to the stream if it is full (equal to 8)
        if (bitCounter == 8) {
            output.write(b);
            // Reset the bit counter.
            bitCounter = 0;
            // Reset the byte to empty.
            b = 0;
        }
    }

    /**
     * Writes a string of bits to the output stream.
     *
     * @param bit
     * @throws java.io.IOException
     */
    public void writeBit(String bit) throws IOException {
        // For each character in the string bit
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    @Override // Override the close method of the AutoClosable interface
    public void close() throws Exception {
        // If the byte is not full
        if (bitCounter > 0) {
            // Add zeros in the least significant bit positions
            b = (byte) (b << (8 - bitCounter));
            // Write the resulting bit sequence to the output
            output.write((byte) b);
        }
        output.close(); // Close the output stream
    }
}
