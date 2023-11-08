import java.util.Scanner;

public class Main {

    public static long maximizeOR(long N, long L, long R) {
        long x = N;

        // If x is within the range, it's already maximized
        if (x >= L && x <= R) {
            return x;
        }

        // If x is less than L, set x to L because it's the smallest value within the
        // range
        if (x < L) {
            x = L;
        }

        // If x is greater than R, we need to adjust the bits
        if (x > R) {
            for (int i = 63; i >= 0; i--) {
                long mask = 1L << i;

                // Check if the bit at this position is the same for both x and N
                if ((x & mask) != 0 && (N & mask) != 0) {
                    // Try setting the current bit to 0 and all less significant bits to 1
                    long potentialX = (x & ~mask) | (mask - 1);

                    // If potentialX is less than L, we can't set this bit to 0
                    if (potentialX < L) {
                        continue;
                    }

                    // Otherwise, if potentialX is within the range [L, R], we can set this bit to 0
                    if (potentialX <= R) {
                        x = potentialX;
                        break;
                    }
                }
            }
        }

        // Ensure that x is within the range [L, R]
        return Math.min(Math.max(x, L), R);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long L = scanner.nextLong();
        long R = scanner.nextLong();

        System.out.println(maximizeOR(N, L, R));
    }
}
