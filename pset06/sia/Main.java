import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        boolean isStack = true, isQueue = true, isPriorityQueue = true;

        for (int i = 0; i < N; i++) {
            int operation = sc.nextInt();

            if (operation == 1) {
                int x = sc.nextInt();
                if (isStack)
                    stack.push(x);
                if (isQueue)
                    queue.offer(x);
                if (isPriorityQueue)
                    priorityQueue.offer(x);
            } else {
                int x = sc.nextInt();
                if (isStack && (stack.isEmpty() || !stack.pop().equals(x)))
                    isStack = false;
                if (isQueue && (queue.isEmpty() || !queue.poll().equals(x)))
                    isQueue = false;
                if (isPriorityQueue && (priorityQueue.isEmpty() || !priorityQueue.poll().equals(x)))
                    isPriorityQueue = false;
            }
        }

        int count = 0;
        if (isStack)
            count++;
        if (isQueue)
            count++;
        if (isPriorityQueue)
            count++;

        if (count == 0) {
            System.out.println("impossible");
        } else if (count == 1) {
            if (isStack) {
                System.out.println("stack");
            } else if (isQueue) {
                System.out.println("queue");
            } else {
                System.out.println("priority queue");
            }
        } else {
            System.out.println("not sure");
        }
        sc.close();
    }
}
