import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            int operations = 0;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n; j++) {
                    char rowChar = matrix[i][j];
                    char colChar = matrix[j][n - i - 1];
                    if (rowChar != colChar) {
                        if (rowChar < colChar || rowChar == 'z') {
                            operations += colChar - rowChar;
                        } else {
                            operations += rowChar - colChar;
                        }
                    }
                }
            }
            System.out.println(operations);

        }
    }
}
