package week_1;// Double space files specified on command line.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DoubleSpace {
    public static void main(String[] args) {
        /* for each filepath specified, call doubleSpace() to manipulate the file */
        for (String filePath : args) {
            doubleSpace(filePath);
        }
    }

    public static void doubleSpace(String fileName) {
        Scanner sc = null;
        PrintWriter f = null;

        try {
            // Opening of files for input and output
            sc = new Scanner(new FileReader(fileName));
            // Double space the lines
            f = new PrintWriter(new FileWriter(fileName + ".ds"));

            while (sc.hasNextLine()) {
                f.println(sc.nextLine() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {// Close the files if they have been opened.
            sc.close();
            f.close();
        }
    }
}