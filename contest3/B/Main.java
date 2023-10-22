import java.util.Scanner;

public class Main {
    public static boolean canFormPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int oddFreqCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddFreqCount++;
            }
        }
        int minRemovals = Math.max(0, oddFreqCount - 1);
        if (k < minRemovals) {
            return false;
        }

        return oddFreqCount <= k + 1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline character
            String s = sc.nextLine();

            System.out.println(canFormPalindrome(s, k) ? "YES" : "NO");
        }
    }
}
