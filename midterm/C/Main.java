import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalScore = 0;
        int totalReviews = 0;
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int numReviews = sc.nextInt();

            for (int j = 0; j < scores.size(); j++) {
                minHeap.offer(scores.get(j));
                maxHeap.offer(scores.get(j));
            }

            for (int j = 0; j < numReviews; j++) {
                int score = sc.nextInt();
                scores.add(score);
                totalScore += score;
                minHeap.offer(score);
                maxHeap.offer(score);
                totalReviews++;
                // System.out.println(totalScore + " " + totalReviews);
            }

            while (minHeap.size() > 3) {
                minHeap.poll();
            }
            while (maxHeap.size() > 3) {
                maxHeap.poll();
            }

            while (!minHeap.isEmpty()) {

                scores.remove(minHeap.peek());
                totalScore -= minHeap.poll();
                totalReviews--;

            }
            while (!maxHeap.isEmpty()) {

                scores.remove(maxHeap.peek());
                totalScore -= maxHeap.poll();
                totalReviews--;
            }

            // System.out.println(totalScore + " " + totalReviews);
            // if total review is 0 print 0
            if (totalReviews == 0) {
                System.out.println(0);
            } else {
                System.out.println(totalScore / totalReviews);
            }
            minHeap.clear();
            maxHeap.clear();
        }
        sc.close();
    }
}
