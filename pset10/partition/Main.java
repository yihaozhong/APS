import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println(minimizeMaxSum(A, M));
        scanner.close();
    }

    private static long minimizeMaxSum(int[] A, int M) {
        long left = 0, right = 0;
        for (int value : A) {
            right += value;
            if (value > left) {
                left = value;
            }
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(A, M, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] A, int M, long maxSum) {
        int count = 1;
        long currentSum = 0;
        for (int value : A) {
            currentSum += value;
            if (currentSum > maxSum) {
                currentSum = value;
                count++;
                if (count > M) {
                    return false;
                }
            }
        }
        return true;
    }
}
