import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        double maxDist = 0;

        maxDist = Math.max(maxDist, arr[0]);
        maxDist = Math.max(maxDist, len - arr[n - 1]);

        for (int i = 1; i < n; i++) {
            maxDist = Math.max(maxDist, (arr[i] - arr[i - 1]) / 2.0);
        }

        System.out.println(maxDist);
    }
}
