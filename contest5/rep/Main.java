import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Reading the first integer if it's important
        sc.nextLine(); // Move to the next line after reading integer
        String s = sc.nextLine();

        if (s == null || s.isEmpty()) {
            System.out.print(0);
            return;
        }

        Set<String> uniqueSubstrings = new HashSet<>();
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                currentSubstring = new StringBuilder();
            }
            currentSubstring.append(s.charAt(i));
            uniqueSubstrings.add(currentSubstring.toString());
        }

        System.out.print(uniqueSubstrings.size());
    }
}
