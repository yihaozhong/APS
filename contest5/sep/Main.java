import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // seperate the string and add space between words
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split("");
        for (int i = 0; i < (words.length - 1); i++) {
            System.out.print(words[i] + " ");
        }
        System.out.print(words[words.length - 1]);
    }
}
