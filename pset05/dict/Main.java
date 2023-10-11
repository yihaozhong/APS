
import java.util.Scanner;

public class Main {
    private static int[][] C = new int[27][27]; // Combination values

    private static void computeCombinations() {
        for (int i = 0; i <= 26; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    public static int getRank(String s) {
        int rank = 0;
        int len = s.length();
        
        for (int i = 1; i < len; i++) {
            rank += C[26][i];
        }
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            for (char prev = (i == 0 ? 'a' : (char) (s.charAt(i - 1) + 1)); prev < ch; prev++) {
                rank += C['z' - prev][len - i - 1];
            }
        }
        return rank + 1;
    }
    public static boolean isValid(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        computeCombinations();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(isValid(s)){
        System.out.print(getRank(s));
        }else{
            System.out.print(0);
        }
    }
}
