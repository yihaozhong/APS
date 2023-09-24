
import java.util.Scanner;

public class walkOverMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int totalPlayers = (int) Math.pow(2, N);
        int[] players = new int[totalPlayers];
        
        for (int i = 0; i < M; i++) {
            int absentPlayer = in.nextInt();
            players[absentPlayer - 1] = 1;  // Mark the player as absent
        }
        in.close();

        int walkovers = 0;
        int nextRoundPlayers = totalPlayers / 2;
        while (nextRoundPlayers > 0) {
            int[] nextRound = new int[nextRoundPlayers];
            for (int i = 0, j = 0; i < totalPlayers; i += 2, j++) {
                if (players[i] == 1 && players[i + 1] == 1) {
                    nextRound[j] = 1;  // Both players are absent
                } else if (players[i] == 1 || players[i + 1] == 1) {
                    walkovers++;
                    nextRound[j] = 0;  // One player is present
                } else {
                    nextRound[j] = 0;  // Both players are present
                }
            }
            players = nextRound;
            totalPlayers /= 2;
            nextRoundPlayers /= 2;
        }
        System.out.print(walkovers);
    }
}
