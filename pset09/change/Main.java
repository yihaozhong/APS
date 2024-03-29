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

        int maxCoinValue = Arrays.stream(coins).max().getAsInt();
        int[] dp = new int[M + maxCoinValue + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Populate the dp array with the minimum number of coins needed for each sum
        for (int coin : coins) {
            for (int j = dp.length - 1; j >= coin; j--) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        // Find the minimum overpayment and number of coins used
        int totalPaid = -1;
        int coinsUsed = Integer.MAX_VALUE;
        for (int i = M; i < dp.length; i++) {
            if (dp[i] < coinsUsed) {
                totalPaid = i;
                coinsUsed = dp[i];
                break;
            }
        }
    

        System.out.println(totalPaid + " " + coinsUsed);
    }
}
