import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String pin = sc.next();
            int time = 0;
            for (int i = 0; i < pin.length(); i++) {
                int digit = pin.charAt(i) - '0';
                if (digit == 0)
                    digit = 10;
                if (i == 0) {
                    time += Math.abs(digit - 1);
                } else {
                    int prevDigit = pin.charAt(i - 1) - '0';
                    if (prevDigit == 0)
                        prevDigit = 10;
                    time += Math.abs(digit - prevDigit);
                }
            }
            time += pin.length();
            System.out.println(time);
        }
        sc.close();
    }
}