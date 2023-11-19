import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] voteCounts = new int[N + 1];
        int maxVotes = 0;
        int currentWinner = 1;

        for (int i = 0; i < M; i++) {
            int vote = sc.nextInt();
            voteCounts[vote]++;

            // Check if the current vote changes the winner
            if (voteCounts[vote] > maxVotes || (voteCounts[vote] == maxVotes && vote < currentWinner)) {
                maxVotes = voteCounts[vote];
                currentWinner = vote;
            }

            System.out.println(currentWinner);
        }

        sc.close();
    }
}
