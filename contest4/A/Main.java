import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String canSort(int n, int[] a) {
        boolean hasAdjacentOutOfOrder = false;

        // Check if there's at least one pair of adjacent numbers which are out of
        // order.
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                hasAdjacentOutOfOrder = true;
                break;
            }
        }

        if (!hasAdjacentOutOfOrder) {
            return "NO";
        }

        // If the array is already sorted, return "YES".
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return "NO";
            }
        }

        return "YES";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n;
        t = sc.nextInt();
        n = sc.nextInt();

        while (t-- > 0) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // choose a non negative integer m, such that 2^m <= n
            // subtract 1 from a_i for all i, such that 1<=i <= 2^m
            // can you sort the array in non-descreaing order by performing some number of
            // operations?
            // return "YES" if possible, otherwise return "NO
            // 1 2 3 4 5, aready non decreasing
            // 6 5 3 4 4, we can choose m = 1 twice, and subtract 1 from a_1 and a_2, get 4
            // 3 3 4 4, and we can choose m = 0 and get 3 3 3 4 4
            System.out.println(canSort(n, a));
        }
    }
}
