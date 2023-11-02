import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        // Read and sort plot radii
        double[] plotRadii = new double[N];
        for (int i = 0; i < N; i++) {
            plotRadii[i] = scanner.nextDouble();
        }
        Arrays.sort(plotRadii);

        // Read and sort circular house radii
        double[] circularHouseRadii = new double[M];
        for (int i = 0; i < M; i++) {
            circularHouseRadii[i] = scanner.nextDouble();
        }
        Arrays.sort(circularHouseRadii);

        // Read and sort square house diagonal lengths (diagonal is s * sqrt(2))
        double[] squareHouseDiagonals = new double[K];
        for (int i = 0; i < K; i++) {
            squareHouseDiagonals[i] = scanner.nextDouble() * Math.sqrt(2) / 2;
        }
        Arrays.sort(squareHouseDiagonals);

        int plotsFilled = 0;
        int plotIndex = N - 1; //
        int circularHouseIndex = M - 1; //
        int squareHouseIndex = K - 1; //

        while (plotIndex >= 0 && squareHouseIndex >= 0) {
            if (squareHouseDiagonals[squareHouseIndex] < plotRadii[plotIndex]) {
                plotsFilled++;
                squareHouseIndex--;
            }
            plotIndex--;
        }

        while (plotIndex >= 0 && circularHouseIndex >= 0) {
            if (circularHouseRadii[circularHouseIndex] < plotRadii[plotIndex]) {
                plotsFilled++;
                circularHouseIndex--;
            }
            plotIndex--;
        }

        System.out.println(plotsFilled);
        scanner.close();
    }
}
