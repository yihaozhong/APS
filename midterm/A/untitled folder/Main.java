import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 0, b = 0, count = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                if (count % 2 == 0) {
                    a = a | (1 << i);
                } else {
                    b = b | (1 << i);
                }
                count++;
            }
        }
        System.out.println(a + " " + b);

        sc.close();
    }
}