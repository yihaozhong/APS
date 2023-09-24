
import java.util.Scanner;

public class primePair {
    // public static boolean isPrime(int num){
    //     if (num == 2 || num == 3 || num == 5)
    //         return true;
    //     if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0)
    //         return false;

    //     int i = 5;
    //     while (i*i  <= num){
    //         if ((num % i == 0) || (num % (i+2) ==0))
    //             return false;
    //         i += 6;
    //     }
    //     return true;
    // }
    
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int n = in.nextInt();
    //     int prime = 3;
    //     int cnt = 0;
    //     int next_prime = 0;
    //     while (true){
    //         next_prime = prime + 1;
    //         while (!isPrime(next_prime)){
    //             next_prime ++;
    //         }
    //         if (next_prime - prime == 2){
    //             cnt += 1;
    //             if (cnt == n){
    //                 System.out.println("("+prime + ", " + next_prime+")");
    //                 break;
    //             }
    //         }
    //         prime = next_prime;
    //     }
        
    //     in.close();
    // }

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
