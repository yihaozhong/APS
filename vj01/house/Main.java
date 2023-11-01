import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // plots
        int M = scanner.nextInt(); // circular houses
        int K = scanner.nextInt(); // square houses

        double[] plotRadii = new double[N];
        for (int i = 0; i < N; i++) {
            plotRadii[i] = scanner.nextDouble();
        }
        Arrays.sort(plotRadii);

        double[] cirHouse = new double[M];
        for (int i = 0; i < M; i++) {
            cirHouse[i] = scanner.nextDouble();
        }
        Arrays.sort(cirHouse);

        double[] squareHouse = new double[K];
        for (int i = 0; i < K; i++) {
            squareHouse[i] = scanner.nextDouble() * Math.sqrt(2) / 2;
        }
        Arrays.sort(squareHouse);

        int plotsFilled = 0;
        int circularHouseIndex = M - 1; // Start from the largest
        int squareHouseIndex = K - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (circularHouseIndex >= 0 && cirHouse[circularHouseIndex] < plotRadii[i]) {
                // Fit a circular
                plotsFilled++;
                circularHouseIndex--;
            } else if (squareHouseIndex >= 0 && squareHouse[squareHouseIndex] < plotRadii[i]) {
                // square
                plotsFilled++;
                squareHouseIndex--;
            }
        }

        System.out.println(plotsFilled);
        scanner.close();
    }
}
