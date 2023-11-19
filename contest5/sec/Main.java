import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int index = 0; index < n; index++) {
            arr[index] = sc.nextInt();
        }

        int max = 0;
        int secondMax = 0;
        for (int index = 0; index < n; index++) {
            if (arr[index] == max || arr[index] == secondMax) {
                continue;
            }
            if (arr[index] > max) {
                secondMax = max;
                max = arr[index];
            } else if (arr[index] > secondMax) {
                secondMax = arr[index];
            }
        }
        System.out.print(secondMax);
    }
}
