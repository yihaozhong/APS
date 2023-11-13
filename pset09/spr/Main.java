import java.util.*;

class Sprinkler implements Comparable<Sprinkler> {
    double left, right;

    public Sprinkler(int position, int radius, int width) {
        double effectiveRadius = Math.sqrt(Math.max(0, radius * radius - (width * width / 4.0)));
        left = Math.max(0, position - effectiveRadius);
        right = position + effectiveRadius;
    }

    @Override
    public int compareTo(Sprinkler other) {
        return Double.compare(this.left, other.left);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int w = scanner.nextInt();

        List<Sprinkler> sprinklers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int position = scanner.nextInt();
            int radius = scanner.nextInt();
            sprinklers.add(new Sprinkler(position, radius, w));
        }

        Collections.sort(sprinklers);

        int count = 0;
        double covered = 0;
        int index = 0;
        while (covered < l) {
            double maxRight = covered;
            while (index < n && sprinklers.get(index).left <= covered) {
                maxRight = Math.max(maxRight, sprinklers.get(index).right);
                index++;
            }

            if (maxRight == covered) {
                count = -1;
                break;
            }

            covered = maxRight;
            count++;
        }

        System.out.println(count);
    }
}
