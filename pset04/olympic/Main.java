import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();  // number of patches
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();  
            
            for (int j = 0; j < k; j++) {
                int score = scanner.nextInt();
                minHeap.add(score);
                maxHeap.add(score);
            }
            
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                int smallest = minHeap.poll();
                int largest = maxHeap.poll();
                
            
                System.out.println(largest - smallest);

                minHeap.remove(largest);
                maxHeap.remove(smallest);
            } else {
                System.out.println(0);
            }
        }
        
        scanner.close();
    }
}
