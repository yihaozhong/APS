import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] problems = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            problems[i][0] = Integer.parseInt(input[0]); // ai
            problems[i][1] = Integer.parseInt(input[1]); // bi
        }

        Arrays.sort(problems, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

        int totalTime = 0;
        int timeSpentSolving = 0;
        for (int i = 0; i < N; i++) {
            timeSpentSolving += problems[i][0];
            totalTime = Math.max(totalTime, timeSpentSolving + problems[i][1]);
        }

        System.out.println(totalTime);
        scanner.close();
    }
}
