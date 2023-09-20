
import java.util.Scanner;

public class Main {
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int limit = 20000000;  // Given constraint
        boolean[] primes = sieveOfEratosthenes(limit);
        
        int cnt = 0;
        for (int i = 2; i <= limit - 2; i++) {
            if (primes[i] && primes[i + 2]) {
                cnt++;
                if (cnt == n) {
                    System.out.println("(" + i + ", " + (i + 2) + ")");
                    break;
                }
            }
        }
        in.close();
    }
}
