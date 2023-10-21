import java.util.Scanner;

public class Main {

    static int[] parent;
    static int[] size;

    // Find with path compression
    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union of two sets
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number
        int M = sc.nextInt(); //

        parent = new int[N + 1];
        size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            union(A, B);
        }

        int maxSize = 0;
        for (int i = 1; i <= N; i++) {
            maxSize = Math.max(maxSize, size[find(i)]);
        }

        System.out.println(maxSize);
        sc.close();
    }
}
