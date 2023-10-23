import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number
        int m = scanner.nextInt(); // position
        LinkedList<int[]> queue = new LinkedList<>();
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            int priority = scanner.nextInt();
            queue.add(new int[] { i, priority });
            priorities[i] = priority;
        }
        scanner.close();
        Arrays.sort(priorities);
        int time = 0; // not sure
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[1] == priorities[n - 1]) {
                time++;
                n--;
                if (current[0] == m) {
                    System.out.println(time);
                    break;
                }
            } else {
                queue.add(current);
            }
        }
    }
}