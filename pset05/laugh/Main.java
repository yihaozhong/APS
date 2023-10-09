import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double d = sc.nextDouble();
        double[][] guests = new double[n][2];

        for (int i = 0; i < n; i++) {
            guests[i][0] = sc.nextDouble();
            guests[i][1] = sc.nextDouble();
        }

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distance(guests[i], guests[j]) <= d) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        visited = new boolean[n];
        int distinctGroups = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                distinctGroups++;
            }
        }

        System.out.print(distinctGroups);
    }

    static double distance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
