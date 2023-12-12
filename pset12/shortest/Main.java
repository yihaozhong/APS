import java.util.*;

public class Main {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int E = scanner.nextInt();
        int B = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(v, u, w)); // Reverse the edge direction
        }

        int count = countNodesWithPaths(n, E, B, edges);
        System.out.println(count);
    }

    private static int countNodesWithPaths(int n, int E, int B, List<Edge> edges) {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[E] = 0;

        // Bellman-Ford algorithm
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] < Long.MAX_VALUE) {
                    distance[edge.dest] = Math.min(distance[edge.dest],
                            distance[edge.src] + edge.weight);
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] <= B) {
                count++;
            }
        }

        return count;
    }
}
