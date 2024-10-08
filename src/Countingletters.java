import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Countingletters {

    public static void main(String[] args) {
        String fileName = "Guled.txt";

        // Create the text file and write to it
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Wonderful day");
        } catch (IOException e) {
            System.err.println("Somthingwrong: " + e.getMessage());
        }

        // Count letters in the file
        countLetterAll(fileName);
    }

    public static void countLetterAll(String fileName) {
        Map<Character, Integer> letterCount = new HashMap<>();

        // Read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Count each letter in the line
                for (char c : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Somthing Wrong: " + e.getMessage());
        }

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
