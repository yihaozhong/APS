import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Graph {
        private final List<List<Integer>> adjList;

        public Graph(int numCorners) {
            adjList = new ArrayList<>();
            for (int i = 0; i <= numCorners; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to) {
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        public void sortAdjList() {
            for (List<Integer> list : adjList) {
                Collections.sort(list);
            }
        }

        public List<List<Integer>> findAllPaths(int start, int end) {
            sortAdjList(); // Sort adjacency list before finding paths
            List<List<Integer>> paths = new ArrayList<>();
            boolean[] visited = new boolean[adjList.size()];
            List<Integer> pathList = new ArrayList<>();
            pathList.add(start);
            findAllPathsDFS(start, end, visited, pathList, paths);
            return paths;
        }

        private void findAllPathsDFS(int current, int end, boolean[] visited, List<Integer> localPathList,
                List<List<Integer>> paths) {
            if (current == end) {
                paths.add(new ArrayList<>(localPathList));
                return;
            }
            visited[current] = true;
            for (Integer i : adjList.get(current)) {
                if (!visited[i]) {
                    localPathList.add(i);
                    findAllPathsDFS(i, end, visited, localPathList, paths);
                    localPathList.remove(localPathList.size() - 1);
                }
            }
            visited[current] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetCorner = scanner.nextInt();
        Graph graph = new Graph(20); // Since corners are less than 21

        while (scanner.hasNextInt()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            if (from == 0 && to == 0) {
                break;
            }
            graph.addEdge(from, to);
        }

        List<List<Integer>> paths = graph.findAllPaths(1, targetCorner);
        for (List<Integer> path : paths) {
            for (int i = 0; i < path.size() - 1; i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.print(path.get(path.size() - 1));
            System.out.println();
        }
        System.out.print(
                "There are " + paths.size() + " routes from the initial position to corner " + targetCorner + ".");
    }
}
