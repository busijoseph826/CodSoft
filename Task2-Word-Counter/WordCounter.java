import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

    public static int countWords(String text) {
        // Splitting the text into words using space or punctuation as delimiters
        String[] words = text.split("\\s+|\\p{Punct}+");
        return words.length;
    }

    public static void main(String[] args) {
        System.out.println("Please choose an option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");

        try (BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            String choice = reader.readLine();

            if (choice.equals("1")) {
                System.out.print("Enter the text: ");
                String text = reader.readLine();
                int wordCount = countWords(text);
                System.out.println("Total number of words: " + wordCount);
            } else if (choice.equals("2")) {
                System.out.print("Enter the file path: ");
                String filePath = reader.readLine();
                try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder text = new StringBuilder();
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        text.append(line).append("\n");
                    }
                    int wordCount = countWords(text.toString());
                    System.out.println("Total number of words: " + wordCount);
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
