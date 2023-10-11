import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Car {
    int arrivalTime;
    int index; // Original input position

    Car(int time, int idx) {
        this.arrivalTime = time;
        this.index = idx;
    }
}

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Capacity
        int T = sc.nextInt(); // Crossing time
        int M = sc.nextInt(); // Number of cars

        Queue<Car> leftQueue = new LinkedList<>();
        Queue<Car> rightQueue = new LinkedList<>();
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int arrivalTime = sc.nextInt();
            String bank = sc.next();
            if ("left".equals(bank)) {
                leftQueue.offer(new Car(arrivalTime, i));
            } else {
                rightQueue.offer(new Car(arrivalTime, i));
            }
        }
        int currentTime = 0;
        boolean atLeftBank = true;

        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            Queue<Car> currentQueue = atLeftBank ? leftQueue : rightQueue;
            Queue<Car> oppositeQueue = atLeftBank ? rightQueue : leftQueue;

            int carsLoaded = 0;
            while (!currentQueue.isEmpty() && currentQueue.peek().arrivalTime <= currentTime && carsLoaded < N) {
                Car car = currentQueue.poll();
                result[car.index] = currentTime + T;
                carsLoaded++;
            }

            
            if (carsLoaded > 0 || (!oppositeQueue.isEmpty() && oppositeQueue.peek().arrivalTime <= currentTime)) {
    
                currentTime += T;
                atLeftBank = !atLeftBank;
            } else {
                // Wait for the next car from either queue
                int nextTimeCurrent = currentQueue.isEmpty() ? Integer.MAX_VALUE : currentQueue.peek().arrivalTime;
                int nextTimeOpposite = oppositeQueue.isEmpty() ? Integer.MAX_VALUE : oppositeQueue.peek().arrivalTime;
                currentTime = Math.min(nextTimeCurrent, nextTimeOpposite);
                if (nextTimeOpposite < nextTimeCurrent) {
                    currentTime += T;
                    atLeftBank = !atLeftBank;
                }
            }
        }

        for (int unloadTime : result) {
            System.out.println(unloadTime);
        }

    }
}
