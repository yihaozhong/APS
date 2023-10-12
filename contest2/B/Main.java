import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Set<String> memo = new HashSet<>();

    static String getState(List<Integer> numbers, int opsLeft) {
        int sum = 0;
        int product = 1;
        for (int num : numbers) {
            sum += num;
            product *= num;
        }
        return sum + "-" + product + "-" + opsLeft;
    }

    static boolean canMakeEqual(List<Integer> numbers, int opsLeft) {
        if (new HashSet<>(numbers).size() == 1) {
            return true;
        }

        // If ops left is zero and numbers are not all the same, return false
        if (opsLeft == 0) {
            return false;
        }

        String state = getState(numbers, opsLeft);
        if (memo.contains(state)) {
            return false;
        }

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            for (int j = 1; j <= number / 2; j++) {
                // Decompose the number into j and (number - j)
                List<Integer> newNumbers = new ArrayList<>(numbers);
                newNumbers.remove(i);
                newNumbers.add(j);
                newNumbers.add(number - j);
                if (canMakeEqual(newNumbers, opsLeft - 1)) {
                    return true;
                }
            }
        }

        // Store the state as computed
        memo.add(state);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            List<Integer> numbers = new ArrayList<>(Arrays.asList(a, b, c));

            if (a == b && b == c) {
                System.out.println("YES");
                continue;
            }

            memo.clear(); // Clear memo for each test case
            if (canMakeEqual(numbers, 3))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
