// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int numCases = sc.nextInt();
// int[] rungs = new int[numCases + 1];
// rungs[0] = 0;
// for (int i = 1; i <= numCases; i++) {
// rungs[i] = sc.nextInt();
// }

// int[] diffs = new int[numCases];
// for (int i = 1; i < numCases + 1; i++) {
// diffs[i - 1] = rungs[i] - rungs[i - 1];
// }

// // int k = Arrays.stream(diffs).max().getAsInt();
// // boolean flag = true;
// // int cnt = 0;
// // while (flag) {
// // flag = false;
// // cnt = 0;
// // int temp_k = k;
// // for (int diff : diffs) {
// // // System.out.println("diff: " + diff + " k: " + k);
// // if (diff == k) {
// // k--;
// // cnt++;
// // if (k <= 0) {
// // k = temp_k + 1;
// // flag = true;
// // }
// // } else if (diff > k) {
// // k = temp_k + 1;
// // cnt = 0;
// // flag = true;
// // break;
// // }
// // }
// // }
// int k = diffs[numCases - 1];
// for (int i = numCases - 2; i >= 0; i--) {
// if (diffs[i] > k) {
// k = diffs[i];
// } else if (diffs[i] == k) {
// k++;
// }
// }

// // System.out.println("diff: " + diff + " k: " + k);

// System.out.println(k);
// }
// }
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rungs = new int[n];
        for (int i = 0; i < n; i++) {
            rungs[i] = sc.nextInt();
        }

        System.out.println(minK(rungs));
    }

    private static int minK(int[] rungs) {
        int lo = 0;
        int hi = 10000000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canReachTop(rungs, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean canReachTop(int[] rungs, int k) {
        int lastRung = 0;
        for (int rung : rungs) {
            if (rung - lastRung > k) {
                return false;
            } else if (rung - lastRung == k) {
                k--;
            }
            lastRung = rung;
        }
        return true;
    }
}