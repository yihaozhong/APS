import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] blockHeights = new int[N];
        int totalHeight = 0;

        for (int i = 0; i < N; i++) {
            blockHeights[i] = scanner.nextInt();
            totalHeight += blockHeights[i];
        }

        boolean[][] dp = new boolean[N + 1][totalHeight + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= totalHeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= blockHeights[i - 1] && dp[i - 1][j - blockHeights[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }

        int minHeightDiff = totalHeight;
        for (int j = 0; j <= totalHeight / 2; j++) {
            if (dp[N][j]) {
                minHeightDiff = Math.min(minHeightDiff, totalHeight - 2 * j);
            }
        }

        int tower1 = (totalHeight - minHeightDiff) / 2;
        int tower2 = totalHeight - tower1;
        System.out.println(Math.min(tower1, tower2) + " " + Math.max(tower1, tower2));
    }
}
