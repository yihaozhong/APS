import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        boolean[] dp = new boolean[M + 1];
        dp[0] = true;

        for (int i = 0; i < N; i++) {
            int K = scanner.nextInt();
            boolean[] newDp = new boolean[M + 1];

            for (int j = 0; j < K; j++) {
                int price = scanner.nextInt();
                for (int k = 0; k <= M - price; k++) {
                    if (dp[k]) {
                        newDp[k + price] = true;
                    }
                }
            }

            // Check if it's possible to buy from this dessert type
            boolean possible = false;
            for (int k = 1; k <= M; k++) {
                if (newDp[k]) {
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                System.out.println("no solution");
                scanner.close();
                return;
            }

            dp = newDp;
        }

        int result = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[i]) {
                result = i;
                break;
            }
        }

        if (result == -1) {
            System.out.println("no solution");
        } else {
            System.out.println(result);
        }

        scanner.close();
    }
}
