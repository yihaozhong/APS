import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.nextLine();  

        Set<Integer> marySet = readFlowerSet(scanner, x);
        Set<Integer> annSet = readFlowerSet(scanner, y);
        Set<Integer> lucySet = readFlowerSet(scanner, z);

        printResults(marySet, annSet, lucySet);
        System.out.println();
        printResults(annSet, marySet, lucySet);
        System.out.println();
        printResults(lucySet, marySet, annSet);
    }

    private static Set<Integer> readFlowerSet(Scanner scanner, int count) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(scanner.nextInt());
        }
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        return set;
    }

    public static void printResults(Set<Integer> current, Set<Integer> other1, Set<Integer> other2) {
        Set<Integer> bothOthers = new HashSet<>(other1);
        bothOthers.retainAll(other2);  // Intersection of the other two sets

        Set<Integer> uniqueToCurrent = new HashSet<>(current);
        uniqueToCurrent.removeAll(other1);
        uniqueToCurrent.removeAll(other2);  // Removing flowers present in other sets

        bothOthers.removeAll(current);  // Flowers both others have but the current does not

        System.out.print(uniqueToCurrent.size() + " " + bothOthers.size());
    }
}
