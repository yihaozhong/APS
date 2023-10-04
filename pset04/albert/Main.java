import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Set<String> uniqueWords = new TreeSet<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = wordPattern.matcher(line);

            while (matcher.find()) {
                String word = matcher.group().toLowerCase();
                uniqueWords.add(word);
            }
        }

        scanner.close();

        // Print the unique words in alphabetical order
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}
