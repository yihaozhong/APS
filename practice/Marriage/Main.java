import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = 1;
        while (true) {
            int B = sc.nextInt();
            int S = sc.nextInt();

            if (B == 0 && S == 0)
                break;

            int[] bachelors = new int[B];
            for (int i = 0; i < B; i++) {
                bachelors[i] = sc.nextInt();
            }

            for (int i = 0; i < S; i++) {
                sc.nextInt(); // read spinster ages but we don't need to store them
            }

            Arrays.sort(bachelors);

            if (B <= S) {
                System.out.println("Case " + caseNum + ": 0");
            } else {
                System.out.println("Case " + caseNum + ": " + (B - S) + " " + bachelors[0]);
            }

            caseNum++;
        }
    }
}
