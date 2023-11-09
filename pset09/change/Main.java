import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        int[] dp = new int[M + 10001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Update dp array for all coins
        for (int coin : coins) {
            for (int j = coin; j < dp.length; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        // Find the minimum overpayment and number of coins used
        for (int i = M; i < dp.length; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                System.out.println(i + " " + dp[i]);
                break;
            }
        }
    }
}
