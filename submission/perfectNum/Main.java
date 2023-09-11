import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long in = sc.nextLong();
        if (in < 6){
            System.out.println("NOT PERFECT");
        }
        long sum = 1;
        for(long i = 2; i * i <=in ; i++){
            if (in%i == 0){
                sum += (i == in / i) ? i : (i + in / i);
            }
        }

        System.out.println(sum == in ? "PERFECT" : "NOT PERFECT");
        sc.close();
    }
}
