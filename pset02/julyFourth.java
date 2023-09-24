import java.util.ArrayList;
import java.util.Scanner;

public class julyFourth {
     public static ArrayList<Integer> generateJulyFourthNumbers(int limit) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            int num = i;
            boolean isJulyFourth = true;
            while (num > 0) {
                int digit = num % 10;
                if (digit != 4 && digit != 7) {
                    isJulyFourth = false;
                    break;
                }
                num /= 10;
            }
            if (isJulyFourth) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> julyFourthNumbers = generateJulyFourthNumbers(1000000);

        for (int num : julyFourthNumbers) {
            if (n % num == 0) {
                System.out.println("July Fourth Family Number");
                in.close();
                return;
            }
        }
        System.out.println("Not in the family");
        in.close();
    }
}
