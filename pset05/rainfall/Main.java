

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Long> minHeap = new PriorityQueue<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String next = sc.nextLine();
            if (!next.isEmpty()){
                long num = Long.parseLong(next.trim());
                // if ( minHeap.size() == maxHeap.size() ){/*  */
                //     maxHeap.add(num);
                //     minHeap.add(maxHeap.poll());
                // }else{
                //     minHeap.add(num);
                //     maxHeap.add(minHeap.poll());
                // }
                // int median;
                // if (minHeap.size() > maxHeap.size()) {
                //     median = minHeap.peek();
                // } else {
                //     median = (minHeap.peek() + maxHeap.peek()) / 2;
                // }

                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                if(minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                if(minHeap.size() != maxHeap.size())
                    System.out.println(maxHeap.peek());
                else
                    System.out.println((minHeap.peek() + maxHeap.peek()) / 2);


                
                // System.out.println(median);
            }
            
        }
        

    }
}
