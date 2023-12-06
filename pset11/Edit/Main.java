import java.util.*;

public class Main {
    // differ by one letter
    // private static boolean isAdjacent(String a, String b) {
    // int count = 0;
    // int n = a.length();

    // for (int i = 0; i < n; i++) {
    // if (a.charAt(i) != b.charAt(i)) {
    // count++;
    // }
    // if (count > 1) {
    // return false;
    // }
    // }
    // return true;
    // }

    private static List<String> genWord(String word, Set<String> wordSet) {
        List<String> adjacentWords = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = '0'; c <= 'z'; c++) {
                if ((c > '9' && c < 'a') || c == originalChar)
                    continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    adjacentWords.add(newWord);
                }
            }
            chars[i] = originalChar;
        }
        return adjacentWords;
    }

    private static int bfs(Set<String> wordSet, String start, String end) {
        if (start.equals(end))
            return 0;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getFirst();
            int depth = node.getSecond();

            for (String nextWord : genWord(word, wordSet)) {
                if (nextWord.equals(end))
                    return depth + 1;
                if (visited.add(nextWord)) {
                    queue.offer(new Pair<>(nextWord, depth + 1));
                }
            }
        }
        return 0;
    }

    public static List<Integer> findAll(int n, List<String> words, int m,
            List<Pair<String, String>> queries) {

        Set<String> wordSet = new HashSet<>(words);

        List<Integer> results = new ArrayList<>();
        for (Pair<String, String> query : queries) {
            results.add(bfs(wordSet, query.getFirst(), query.getSecond()));
        }

        return results;
    }

    static class Pair<F, S> {
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine().trim());
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        List<Pair<String, String>> queries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] parts = scanner.nextLine().split(" ");
            queries.add(new Pair<>(parts[0], parts[1]));
        }
        List<Integer> results = findAll(n, words, m, queries);
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
