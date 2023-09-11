import java.util.Scanner;


public class add2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        System.out.println(a + b);
        in.close();
    }

}