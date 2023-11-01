import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int V = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);
        int[] gameSizes = new int[N];

        String[] sizes = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            gameSizes[i] = Integer.parseInt(sizes[i]);
        }

        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {
            for (int j = V; j >= gameSizes[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - gameSizes[i]] + gameSizes[i]);
            }
        }

        System.out.println(dp[V]);
        scanner.close();
    }
}
