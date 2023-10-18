import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String sequence = readFromFile();
        int count = countArrows(sequence);
        writeToFile(count);
        String arrow = ">>-->";
    }
    public static String readFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Input.txt"));
        String sequence = sc.nextLine();
        return sequence;
    }
    public static void writeToFile(int count) throws IOException {
        String s = String.valueOf(count);
        Files.writeString(Path.of("OUTPUT.TXT"),s);
    }
    public static int countArrows(String sequence)  {
        int count = 0;
        int index1 = sequence.indexOf(">>-->");
        int index2 = sequence.indexOf("<--<<");
        if (index1 != -1 || index2 != -1) {
            count = countArrow(sequence, ">>-->", count);
            count = countArrow(sequence, "<--<<", count);
        }
        return count;
    }
    public static int countArrow(String sequence, String arrow, int count)  {
        String s= sequence;
        int index = s.indexOf(arrow);
        while (index != -1 ) {
            index = s.indexOf(arrow);
            if (index >= 0 ){
                count++;
                s = s.substring(index+1);
            }
        }
        return  count;
    }
}