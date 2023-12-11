import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C, M, N;
    static boolean[][] water, visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt(); // dimen of chess board
        C = scanner.nextInt();
        M = scanner.nextInt(); // knight moves limit
        N = scanner.nextInt();

        int W = scanner.nextInt();
        water = new boolean[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];

        for (int i = 0; i < W; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            water[x][y] = true;
        }

        int[] result = cntValid();
        System.out.println(result[0] + " " + result[1]);

    }

    private static int[] cntValid() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 1, 1 }); // to be visited in BFS
        visited[1][1] = true;

        int evenCount = 0, oddCount = 0;
        while (!queue.isEmpty()) {
            int[] square = queue.poll();
            int x = square[0], y = square[1];
            int count = 0;

            for (int dx : new int[] { M, -M }) { 
                for (int dy : new int[] { N, -N }) {
                    int[][] twice = new int[][] { 
                                                    { dx, dy }, { dy, dx } };
                    for (int[] d : twice) {
                        int newX = x + d[0], newY = y + d[1];
                        if (isValid(newX, newY)) {
                            count++;
                            if (!visited[newX][newY]) {
                                queue.add(new int[] { newX, newY });
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }

            if (count % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        return new int[] { evenCount, oddCount };
    }

    private static boolean isValid(int x, int y) {
        return x > 0 && x <= R && y > 0 && y <= C && !water[x][y];
    }
}
