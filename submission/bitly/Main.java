import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int register = 0;

        for (int i = 0; i < n; i++) {
            String command = in.next();
            int pos1 = in.nextInt();
            switch (command) {
                case "ONE":
                    register |= (1 << pos1);
                    break;
                case "ZERO":
                    register &= ~(1 << pos1);
                    break;
                case "EITHER":
                    int pos2 = in.nextInt();
                    if (((register >> pos1) & 1) == 1 || ((register >> pos2) & 1) == 1) {
                        register |= (1 << pos1);
                    } else {
                        register &= ~(1 << pos1);
                    }
                    break;
                case "BOTH":
                    int pos3 = in.nextInt();
                    if (((register >> pos1) & 1) == 1 && ((register >> pos3) & 1) == 1) {
                        register |= (1 << pos1);
                    } else {
                        register &= ~(1 << pos1);
                    }
                    break;
            }
        }
        in.close();

        // Print the register value in binary format
        String result = String.format("%32s", Integer.toBinaryString(register)).replace(' ', '0');
        System.out.print(result);
    }
}

