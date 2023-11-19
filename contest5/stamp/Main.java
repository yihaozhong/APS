import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // Move to the next line
        String S = sc.nextLine();
        String T = sc.nextLine();

        char[] X = new char[N];
        java.util.Arrays.fill(X, '#');

        for (int i = 0; i <= N - M; i++) {
            boolean match = true;
            for (int j = 0; j < M; j++) {
                if (S.charAt(i + j) != T.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                for (int j = 0; j < M; j++) {
                    X[i + j] = T.charAt(j);
                }
            }
        }

        if (new String(X).equals(S)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
