import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int N = scanner.nextInt();
        int[] multiset = new int[N];

        for (int i = 0; i < N; i++) {
            multiset[i] = scanner.nextInt();
        }

        Arrays.sort(multiset); // Sort the multiset in ascending order

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        findSubsetsWithSum(subsets, currentSubset, multiset, S, 0);

        System.out.println("Sums of " + S + ":");
        if (subsets.isEmpty()) {
            System.out.println("NONE");
        } else {
            printSubsets(subsets);
        }
    }

    private static void findSubsetsWithSum(List<List<Integer>> subsets, List<Integer> currentSubset, int[] multiset,
            int targetSum, int currentIndex) {
        if (targetSum == 0) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = currentIndex; i < multiset.length; i++) {
            if (i > currentIndex && multiset[i] == multiset[i - 1]) {
                continue; // Skip duplicates to avoid duplicate subsets
            }

            if (targetSum - multiset[i] >= 0) {
                currentSubset.add(multiset[i]);
                findSubsetsWithSum(subsets, currentSubset, multiset, targetSum - multiset[i], i + 1); // Use i + 1 to
                                                                                                      // avoid reusing
                                                                                                      // the same
                                                                                                      // element
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }

    private static void printSubsets(List<List<Integer>> subsets) {
        // Sort each subset in decreasing order
        for (List<Integer> subset : subsets) {
            subset.sort((num1, num2) -> Integer.compare(num2, num1));
        }

        // Sort subsets lexicographically in descending order
        subsets.sort((subset1, subset2) -> {
            int size = Math.min(subset1.size(), subset2.size());
            for (int i = 0; i < size; i++) {
                int cmp = Integer.compare(subset2.get(i), subset1.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(subset2.size(), subset1.size());
        });

        for (List<Integer> subset : subsets) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subset.size(); i++) {
                sb.append(subset.get(i));
                if (i < subset.size() - 1) {
                    sb.append("+");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
