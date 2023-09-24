import java.util.Scanner;
import java.util.Stack;

public class Train {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while(true){
            int[] sequence = new int[n];
            for(int i = 0; i <n; i++){
                sequence[i] = input.nextInt();
            }
            input.nextInt();

            if (sequence[0] == 0){
                break;
            }

            Stack<Integer> stack = new Stack<>();
            int j = 0;

            for(int i =1; i <=n; i++){
                stack.push(i);

                while(!stack.isEmpty() && stack.peek() == sequence[j]){
                    stack.pop();
                    j++;
                    if (j >= n){
                        break;
                    }
                }
            }

            if (stack.isEmpty()){
                System.out.println("Yes");

            }else{
                System.out.println("No");
            }
            break;
        }
        input.close();
    }
}
