import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while(true){
            int first = input.nextInt();
            if (first == 0) {
                break; // End of this block of input
            }
            int[] sequence = new int[n];
            sequence[0] = first;
            for(int i = 1; i <n; i++){
                sequence[i] = input.nextInt();
            }

            if (sequence[0] == 0){
                break;
            }

            Stack<Integer> stack = new Stack<>();
            int j = 0;

            for(int i =1; i <=n; i++){
                stack.push(i);

                while(!stack.isEmpty() && stack.peek() == sequence[j] && j<n){
                    stack.pop();
                    j++;

                }
            }

            if (stack.isEmpty()){
                System.out.println("Yes");

            }else{
                System.out.println("No");
            }
        }
        input.close();
    }
}
