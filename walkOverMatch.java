import java.util.Arrays;
import java.util.Scanner;

public class walkOverMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] players = new int[M];
        for (int i = 0; i < M; i++) {
            players[i] = in.nextInt();
        }
        in.close();

        Arrays.sort(players);

        int walkovers = 0;
        for (int i = 0; i < M - 1; i++) {
            if (players[i + 1] - players[i] == 1 && players[i + 1] % 2 == 0) {
                walkovers++;
                i++;  // Skip the next player since this match is already counted as a walkover
            }
        }

        System.out.println(walkovers);
    }
}
