import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static int mod(int x, int K) {
        int result = x % K;
        if (result < 0) {
            result += K;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int diff = a[i + 1] - a[i];

            sum += mod(diff, k);
        }

        System.out.println(sum);
    }
}