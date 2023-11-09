import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] niceness = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            niceness[i] = sc.nextInt();
        }
        sc.close();

        findNicestPart(niceness);
    }

    private static void findNicestPart(int[] niceness) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < niceness.length; i++) {
            maxEndingHere += niceness[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStart = i + 1;
            } else if (maxEndingHere > maxSoFar ||
                    (maxEndingHere == maxSoFar && (i - tempStart) > (end - start))) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        if (maxSoFar > 0) {
            System.out.println("The nicest part of Y1 is between stops " + (start + 1) + " and " + (end + 2));
        } else {
            System.out.println("Yet another overrated tourist destination");
        }
    }
}
