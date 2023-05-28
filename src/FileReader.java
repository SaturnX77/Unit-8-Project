import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Reads data from a file
 */
public final class FileReader {

   // public static boolean dictWritten = false;

    /*
     * Returns an ArrayList of Strings from a file
     */
    public static ArrayList<String> getStringData(String filename) {
        filename = filename.substring(4).toLowerCase();
        ArrayList<String> tempList = new ArrayList<String>();

        try (InputStream in = FileReader.class.getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while(reader.ready()) tempList.add(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tempList;
    }
}