import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read all number in single line and store in arr
        int n = scanner.nextInt();
        int cnt = 0;
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (cnt == (n - 1) / 2) {
                System.out.println(num);
                break;
            }
            cnt += 1;
        }

    }
}
