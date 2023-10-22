
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(minOperations(arr, k));
        }
        sc.close();
    }

    private static int minOperations(int[] arr, int k) {
        int operations = 0;
        int product = 1;
        for (int num : arr) {
            product *= num;
        }
        if (product % k == 0) {
            return 0;
        }
        int minDifference = Integer.MAX_VALUE;
        for (int num : arr) {
            int difference = (num % k == 0) ? 0 : k - (num % k);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

}
