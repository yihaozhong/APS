import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        int cnt = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            arr[i] = l;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int l = arr[i];
            if (sum + l <= w) {
                sum += l;
                cnt++;
            } else {
                System.out.print(cnt);
                return;
            }
        }
        System.out.print(cnt);
    }
}
