import java.util.ArrayList;
import java.util.Scanner;

public class TaskPlaning {
    public static boolean isOverlap(int s1, int e1, int s2, int e2) {
        return s1 < e2 && s2 < e1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        ArrayList<int[]> oneTimeTasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            oneTimeTasks.add(new int[]{in.nextInt(), in.nextInt()});
        }

        ArrayList<int[]> repeatingTasks = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            repeatingTasks.add(new int[]{in.nextInt(), in.nextInt(), in.nextInt()});
        }
        in.close();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isOverlap(oneTimeTasks.get(i)[0], oneTimeTasks.get(i)[1], oneTimeTasks.get(j)[0], oneTimeTasks.get(j)[1])) {
                    System.out.println("CONFLICT");
                    return;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int start = repeatingTasks.get(i)[0];
            int end = repeatingTasks.get(i)[1];
            int interval = repeatingTasks.get(i)[2];
            while (start <= 1000000) {
                for (int[] task : oneTimeTasks) {
                    if (isOverlap(start, end, task[0], task[1])) {
                        System.out.println("CONFLICT");
                        return;
                    }
                }
                for (int j = 0; j < M; j++) {
                    if (i != j) {
                        int rStart = repeatingTasks.get(j)[0];
                        int rEnd = repeatingTasks.get(j)[1];
                        int rInterval = repeatingTasks.get(j)[2];
                        while (rStart <= 1000000) {
                            if (isOverlap(start, end, rStart, rEnd)) {
                                System.out.println("CONFLICT");
                                return;
                            }
                            rStart += rInterval;
                            rEnd += rInterval;
                        }
                    }
                }
                start += interval;
                end += interval;
            }
        }

        System.out.println("NO CONFLICT");
    }
}
