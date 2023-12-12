import java.util.Scanner;

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
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges[i] = new Edge(u, v, w);
        }

        boolean hasDeficitCycle = detect(N, edges);
        System.out.println(hasDeficitCycle ? "possible" : "not possible");
    }

    private static boolean detect(int N, Edge[] edges) {
        int[] distance = new int[N];
        java.util.Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Relax all edges N-1 times
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] != Integer.MAX_VALUE &&
                        distance[edge.dest] > distance[edge.src] + edge.weight) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                }
            }
        }

        // negative-weight cycles
        for (Edge edge : edges) {
            if (distance[edge.src] != Integer.MAX_VALUE &&
                    distance[edge.dest] > distance[edge.src] + edge.weight) {
                return true;
            }
        }

        return false;
    }
}