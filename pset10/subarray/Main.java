import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger sum = BigInteger.valueOf(1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (n == 1) {
            System.out.println(sc.nextInt());
            return;
        }
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            if (ele >= 1) {
                sum = sum.multiply(BigInteger.valueOf(ele));
            } else if (ele < 0) {
                pq.add(ele);
                if (pq.size() >= 2) {
                    sum = sum.multiply(BigInteger.valueOf(pq.poll()));
                    sum = sum.multiply(BigInteger.valueOf(pq.poll()));
                }
            }
        }
        System.out.println(sum);

    }
}
