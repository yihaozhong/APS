import java.util.*;

public class Main {
    static class Cell {
        int x, y, height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count; // Number of unique islands

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1); // Initialize with -1 to indicate unprocessed cells
            count = 0;
        }

        public int find(int x) {
            if (parent[x] == -1) {
                return x; // Return itself if unprocessed
            }
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--; // Merge two islands
            }
        }

        public void add(int x) {
            if (parent[x] == -1) {
                parent[x] = x;
                count++; // New island added
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int size = n * m;
        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int height = scanner.nextInt();
                cells.add(new Cell(i, j, height));
            }
        }

        // Sort cells by height in descending order
        cells.sort((a, b) -> b.height - a.height);

        int T = scanner.nextInt();
        int[] seaLevels = new int[T];
        for (int i = 0; i < T; i++) {
            seaLevels[i] = scanner.nextInt();
        }

        UnionFind uf = new UnionFind(size);
        int[] islandCount = new int[T];
        boolean[] processed = new boolean[size];
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int index = 0;

        for (int t = 0; t < T; t++) {
            while (index < size && cells.get(index).height > seaLevels[t]) {
                int x = cells.get(index).x;
                int y = cells.get(index).y;
                int cellIndex = x * m + y;
                processed[cellIndex] = true;
                uf.add(cellIndex);

                for (int k = 0; k < 4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                        int neighborIndex = newX * m + newY;
                        if (processed[neighborIndex]) {
                            uf.union(cellIndex, neighborIndex);
                        }
                    }
                }
                index++;
            }

            islandCount[t] = uf.count;
        }

        for (int i = 0; i < T - 1; i++) {
            System.out.print(islandCount[i] + " ");
        }
        System.out.print(islandCount[T - 1]);

        System.out.println();
        scanner.close();
    }
}
