import java.util.Scanner;

public class Main {

    // Method to check if the current maximum workload is valid
    static boolean isValid(long[] tasks, int m, long maxLoad) {
        long sum = 0;
        int nodesUsed = 1;

        for (long task : tasks) {
            if (sum + task > maxLoad) {
                sum = task;
                nodesUsed++;
                if (nodesUsed > m) {
                    return false;
                }
            } else {
                sum += task;
            }
        }

        return true;
    }

    // Binary search to find the minimum possible maximum workload
    static long findMaxLoad(long[] tasks, int m) {
        long max = 0;
        long sum = 0;
        for (long task : tasks) {
            sum += task;
            max = Math.max(max, task);
        }

        long left = max;
        long right = sum;
        long load = sum;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (isValid(tasks, m, mid)) {
                load = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return load;
    }

    // Method to print the tasks divided among the nodes with '/' separator
    static void distributeTasks(long[] tasks, int m, long maxLoad) {
        int n = tasks.length;
        int[] splits = new int[m - 1];
        long sum = 0;
        int count = 0;

        for (int i = n - 1; i >= 0; --i) {
            if (sum + tasks[i] > maxLoad || i < m - 1 - count) {
                splits[count++] = i + 1;
                sum = tasks[i];
            } else {
                sum += tasks[i];
            }
        }

        for (int i = 0, node = m - 2; i < n; i++) {
            if (node >= 0 && i == splits[node]) {
                System.out.print(" /");
                node--;
            }
            if (i > 0)
                System.out.print(" ");
            System.out.print(tasks[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] tasks = new long[N];
        for (int i = 0; i < N; i++) {
            tasks[i] = scanner.nextLong();
        }
        scanner.close();

        long maxLoad = findMaxLoad(tasks, M);
        distributeTasks(tasks, M, maxLoad);
    }
}
