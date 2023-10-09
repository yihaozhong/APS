import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();
        scanner.close();
        
        ArrayList<String> results = new ArrayList<>();
        generateSequences(source, target, new Stack<Character>(), "", 0, 0, results);

        Collections.sort(results);

        System.out.println("[");
        for (String seq : results) {
            System.out.println(seq);
        }
        System.out.println("]");
    }
    
    public static void generateSequences(String source, String target, Stack<Character> stack, String sequence, int srcIndex, int tgtIndex, ArrayList<String> results) {
  
        if (tgtIndex == target.length() && stack.isEmpty()) {
            results.add(sequence.trim());
            return;
        }


        if (!stack.isEmpty() && stack.peek() == target.charAt(tgtIndex)) {
            stack.pop();
            generateSequences(source, target, stack, sequence + "o ", srcIndex, tgtIndex + 1, results);
            stack.push(target.charAt(tgtIndex));  // backtrack
        }


        if (srcIndex < source.length()) {
            stack.push(source.charAt(srcIndex));
            generateSequences(source, target, stack, sequence + "i ", srcIndex + 1, tgtIndex, results);
            stack.pop();  // backtrack
        }
    }
}
