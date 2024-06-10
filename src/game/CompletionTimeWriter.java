package game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * keep track the completion time in txt
 */

public class CompletionTimeWriter {

    // instance variable to store the name of the file to write to
    private String fileName;

    // constructor for the CompletionTimeWriter class that takes a file name as a parameter
    public CompletionTimeWriter(String fileName) {
        this.fileName = fileName;
    }

    // method to write the completion time to a file
    public void writeHighScore(String text)
            throws IOException {
        // boolean flag to indicate whether to append to the file or overwrite it
        boolean append = true;
        // FileWriter object to write to the file
        FileWriter writer = null;
        try {
            // create a new FileWriter object using the specified file name and append flag
            writer = new FileWriter(fileName, append);
            // write the specified text to the file, followed by a newline character
            writer.write(text +  "\n" );

        } finally {
            // ensure that the writer is closed regardless of whether an exception is thrown
            if (writer != null) {
                writer.close();
            }
        }
    }
}
