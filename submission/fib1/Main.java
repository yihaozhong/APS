import java.util.Scanner;

public class Main {
    public static int fib(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        memo[n] = (fib(n - 1, memo) + fib(n - 2, memo));
        return memo[n];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fib(n, new int[n + 1]));
        in.close();
    }
}
