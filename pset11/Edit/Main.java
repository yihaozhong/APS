import java.util.*;

public class Main {
    // Function to check if two words differ by exactly one letter
    private static boolean isAdjacent(String a, String b) {
        int count = 0;
        int n = a.length();

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private static int bfs(String start, String end, Map<String, List<String>> graph) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair<>(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getFirst();
            int depth = node.getSecond();

            if (word.equals(end)) {
                return depth;
            }

            for (String adjacent : graph.get(word)) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.add(new Pair<>(adjacent, depth + 1));
                }
            }
        }

        return 0;
    }

    public static List<Integer> wordLadderTransformations(int n, List<String> words, int m,
            List<Pair<String, String>> queries) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : words) {
            graph.put(word, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isAdjacent(words.get(i), words.get(j))) {
                    graph.get(words.get(i)).add(words.get(j));
                    graph.get(words.get(j)).add(words.get(i));
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        for (Pair<String, String> query : queries) {
            results.add(bfs(query.getFirst(), query.getSecond(), graph));
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
            String[] parts = scanner.nextLine().trim().split(" ");
            queries.add(new Pair<>(parts[0], parts[1]));
        }
        List<Integer> results = wordLadderTransformations(n, words, m, queries);
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
