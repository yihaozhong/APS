import java.util.Scanner;

public class Main {

    private static int getDistance(int num1, int num2) {
        if (num1 == 0)
            num1 = 10;
        if (num2 == 0)
            num2 = 10;
        return Math.abs(num1 - num2);

    }

    private static int getPinCodeTime(String pinCode) {
        int totalTime = 0;
        int prevDigit = '1' - '0'; // Starting position
        for (char c : pinCode.toCharArray()) {
            int currentDigit = c - '0';
            totalTime += getDistance(prevDigit, currentDigit) + 1; // +1 for the press time
            prevDigit = currentDigit;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        sc.nextLine(); // consume the newline character

        for (int i = 0; i < t; i++) {
            String pin = sc.nextLine();

            System.out.println(getPinCodeTime(pin));
        }
    }
}
