

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    

    public static void addNum(int num){
        if (maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        // Balance heaps
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static int findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String next = sc.nextLine();
            if (!next.isEmpty()){
                addNum(Integer.parseInt(next.trim()));
                System.out.println(findMedian());
            }
            
        }
        

    }
}
