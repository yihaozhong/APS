import java.util.*;

import org.w3c.dom.Node;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public double averageShortestPathLength() {
        double sum = 0;
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            int[] dist = shortestPath(i);
            for (int j = 0; j < V; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    cnt += 1;
                    sum += dist[j];
                }
            }
        }
        int n = cnt * (cnt - 1);
        System.out.println(sum + " " + n);
        return sum / n;
    }

    private int[] shortestPath(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == Integer.MAX_VALUE) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }

        return dist;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean read = true;
        int cnt = 0;
        Graph aG = new Graph(100);
        while (read) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                if (!sc.hasNext()) {
                    read = false;
                } else {
                    cnt++;
                    double averageDistance = aG.averageShortestPathLength();
                    System.out.printf("Case %d: average length between pages = %.3f clicks%n", cnt,
                            averageDistance);
                    // reset the graph
                    aG = new Graph(100);
                }
            } else {

                aG.addEdge(a, b);
            }
        }
    }

}