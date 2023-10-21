import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        // Initialize the days array to false
        boolean[] days = new boolean[m];

        // For each labor union
        for (int i = 0; i < n; i++) {
            int s_i = sc.nextInt();
            for (int j = s_i - 1; j < m; j += s_i) {
                days[j] = true; // Mark the day as a strike day
            }
        }

        int strikeDays = 0;
        for (int i = 0; i < m; i++) {
            // Check if the day is neither Saturday nor Sunday and there's a strike
            if (days[i] && i % 7 != 5 && i % 7 != 6) {
                strikeDays++;
            }
        }

        System.out.println(strikeDays);

        sc.close();
    }
}
