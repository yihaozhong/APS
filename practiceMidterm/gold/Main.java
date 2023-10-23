import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // iterate the arr, if adjacent elements add up to even, delete them from arr;
        // do so
        // until no more adjacent elements add up to even; use optimze algo to prevent
        // tle

        // int i = 0;
        // while (i < arr.length - 1) {
        // if ((arr[i] + arr[i + 1]) % 2 == 0) {
        // int[] temp = new int[arr.length - 2];
        // for (int j = 0; j < i; j++) {
        // temp[j] = arr[j];
        // }
        // for (int j = i + 2; j < arr.length; j++) {
        // temp[j - 2] = arr[j];
        // }
        // arr = temp;
        // i = 0;
        // } else {
        // i++;
        // }
        // }
        int length = arr.length;
        int i = 0;
        while (i < length - 1) {
            if ((arr[i] + arr[i + 1]) % 2 == 0) {
                // Remove adjacent elements by shifting remaining elements
                for (int j = i + 2; j < length; j++) {
                    arr[j - 2] = arr[j];
                }
                length -= 2;
                if (i > 0) {
                    i--; // Go back one step to check the previous element again
                }
            } else {
                i++;
            }
        }

        System.out.print((length));
    }
}
