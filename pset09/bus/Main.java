import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] niceness = new long[N - 1];

        for (int i = 0; i < N - 1; i++) {
            niceness[i] = sc.nextLong();
        }
        sc.close();

        findNicestPart(niceness);
    }

    private static void findNicestPart(long[] niceness) {
        long maxSoFar = 0;
        long maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;
        boolean foundPositive = false;

        for (int i = 0; i < niceness.length; i++) {
            maxEndingHere += niceness[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStart = i + 1;
            } else {
                foundPositive = true;
                if (maxEndingHere > maxSoFar ||
                        (maxEndingHere == maxSoFar && (i - tempStart) > (end - start))) {
                    maxSoFar = maxEndingHere;
                    start = tempStart;
                    end = i;
                }
            }
        }

        if (!foundPositive) {
            System.out.println("Yet another overrated tourist destination");
        } else {
            // We add 1 to start and end since stops are 1-indexed, and add 1 to end to
            // include the last stop
            System.out.println("The nicest part of Y1 is between stops " + (start + 1) + " and " + (end + 2));
        }
    }
}
