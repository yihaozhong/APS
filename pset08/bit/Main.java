import java.util.Scanner;

public class Main {

    public static long maximizeOR(long N, long L, long R) {
        long x = R;

        for (int i = 31; i >= 0; i--) {
            long mask = 1L << i;

            // Check if x and N both have 1 in the current bit position.
            if (((x & mask) != 0) && ((N & mask) != 0)) {
                long potentialX = (x & ~mask) | ((mask - 1) & ~N);

                // If potentialX is within the range and greater than or equal to L, update x
                if (potentialX >= L) {
                    x = potentialX;
                }
            }
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long L = scanner.nextLong();
        long R = scanner.nextLong();

        System.out.println(maximizeOR(N, L, R));
    }
}
