import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        scanner.nextLine();

        String[] firstTune = scanner.nextLine().split(" ");
        String[] secondTune = scanner.nextLine().split(" ");

        if (areTunesSimilar(firstTune, secondTune)) {
            System.out.print("S");
        } else {
            System.out.print("N");
        }
    }
    private static boolean areTunesSimilar(String[] firstTune, String[] secondTune) {
        String firstIntervals = getIntervalsAsString(firstTune);
        String secondIntervals = getIntervalsAsString(secondTune);

        // Use KMP algorithm for efficient string matching
        return kmpMatch(firstIntervals, secondIntervals) || kmpMatch(secondIntervals, firstIntervals);
    }

    private static boolean kmpMatch(String text, String pattern) {
        if (pattern.isEmpty()) return true;
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
                if (j == pattern.length()) {
                    return true; // found pattern
                }
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    private static String getIntervalsAsString(String[] tune) {
        StringBuilder intervals = new StringBuilder();
        for (int i = 0; i < tune.length - 1; i++) {
            int interval = (getNoteValue(tune[i + 1]) - getNoteValue(tune[i]) + 12) % 12;
            intervals.append(interval).append(",");
        }
        return intervals.toString();
    }

    private static int getNoteValue(String note) {
        switch (note) {
            case "A":
                return 0;
            case "A#":
            case "Bb":
                return 1;
            case "B":
            case "Cb":
                return 2;
            case "C":
            case "B#":
                return 3;
            case "C#":
            case "Db":
                return 4;
            case "D":
                return 5;
            case "D#":
            case "Eb":
                return 6;
            case "E":
            case "Fb":
                return 7;
            case "F":
            case "E#":
                return 8;
            case "F#":
            case "Gb":
                return 9;
            case "G":
                return 10;
            case "G#":
            case "Ab":
                return 11;
            default:
                throw new IllegalArgumentException("Invalid note: " + note);
        }
    }
}
