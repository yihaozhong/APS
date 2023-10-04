import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> operators = new Stack<>();
        LinkedList<Character> output = new LinkedList<>();

        while (sc.hasNextLine()) {
            char token = sc.nextLine().charAt(0);

            switch (token) {
                case '+':
                case '-':
                    while (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-' || 
                           operators.peek() == '*' || operators.peek() == '/' || operators.peek() == '^')) {
                        output.add(operators.pop());
                    }
                    operators.push(token);
                    break;
                case '*':
                case '/':
                    while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/' || operators.peek() == '^')) {
                        output.add(operators.pop());
                    }
                    operators.push(token);
                    break;
                case '^':
                    operators.push(token);
                    break;
                case '(':
                    operators.push(token);
                    break;
                case ')':
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        output.add(operators.pop());
                    }
                    operators.pop();  // Pop '('
                    break;
                default:  // Operand
                    output.add(token);
                    break;
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        for (char c : output) {
            System.out.print(c);
        }
    }
}
