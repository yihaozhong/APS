import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        String X = input1[1];

        String[] input2 = scanner.nextLine().split(" ");
        int m = Integer.parseInt(input2[0]);
        String Y = input2[1];

        int minUpdates = findDP(X, Y, n, m);
        System.out.println(minUpdates);
        scanner.close();
    }

    private static int findDP(String X, String Y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j; // = j (all insertions)
                } else if (j == 0) {
                    dp[i][j] = i; // Min. operations = i (deletions)
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], // Remove
                            dp[i][j - 1], // Insert
                            dp[i - 1][j - 1]); // Replace
                }
            }
        }
        return dp[n][m];
    }

    private static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
