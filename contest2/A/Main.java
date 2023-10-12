import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // s appear in x as substring
        while (N-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String x = sc.nextLine();
            String s = sc.nextLine();
            int cnt = 0;
            if (x.contains(s)) {
                System.out.println(cnt);
                continue;
            }
            while (!x.contains(s)) {
                x = x + x;
                n += n;
                cnt++;
                // System.out.println(x);
                if (x.contains(s)) {
                    System.out.println(cnt);
                    break;
                }
                if (n >= m * 2)
                    break;

            }
            if (!x.contains(s))
                System.out.println(-1);
        }
    }
}
