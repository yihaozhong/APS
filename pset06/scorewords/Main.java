import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // number of words in the dictionary
        int n = sc.nextInt(); // number of sentences
        sc.nextLine();

        // Create a dictionary map
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String word = sc.next();
            int score = sc.nextInt();
            dictionary.put(word, score);
        }
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int sentenceScore = 0;
            while (true) {
                String line = sc.nextLine();
                if (line.equals("."))
                    break; // end of a sentence

                String[] words = line.split(" ");
                for (String word : words) {
                    // If the word is in the dictionary, add its score
                    if (dictionary.containsKey(word)) {
                        sentenceScore += dictionary.get(word);
                    }
                }
            }
            System.out.println(sentenceScore);
        }

        sc.close();
    }

}
