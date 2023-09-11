import java.util.Scanner;

public class Main {
   public static long fib2(int n, long[] memo){
        if (memo[n] != 0){
            return memo[n];
        }
        if (n <= 1){
            return 0;
        }
        if (n == 2){
            memo[n] = 1;
            return 1;
        }
        memo[n] = (fib2(n -1, memo) + fib2(n-2, memo));
        return memo[n];
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fib2(n, new long[n+1]));
        in.close();
    }
}
