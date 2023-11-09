import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(); // Number of 1's
        int B = scanner.nextInt(); // Number of 0's
        scanner.close();

        System.out.println(findSmallestDesolateNumber(A, B));
    }

    public static long findSmallestDesolateNumber(int A, int B) {
        StringBuilder binary = new StringBuilder();
        int numberOfPatterns = 0;

        // Calculate the number of "101" patterns that can be made
        while (A > 1 && B > 0) {
            numberOfPatterns++;
            A -= 2;
            B--;
        }

        // If A is 1 and B is greater than 1, start with "01"
        if (A == 1 && B > 0) {
            binary.append("01");
            B--;
            A--;
        }
        //System.out.println(binary.toString());

        // Add "101" patterns to the string
        for (int i = 0; i < numberOfPatterns; i++) {
            binary.append("101");
        }
        //System.out.println(binary.toString());

        // Add all remaining '1's to the left of the string
        while (A > 0) {
            binary.append("1");
            A--;
        }
        //System.out.println(binary.toString());

        // Add remaining '0's to the string
        while (B > 0) {
            binary.insert(0, "0");
            B--;
        }
        //System.out.println(binary.toString());
        // Parse the binary string to a Long and return
        return Long.parseLong(binary.toString(), 2);
    }
}
