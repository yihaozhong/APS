import java.util.Scanner;

public class rodScu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String ori = "+x";
        String[] arr = sc.nextLine().split(" ");
        for (int i = 0; i <n-1; i++){
            String next = arr[i];
            
            if (next.equals("No")){
                continue;
            }else if (ori.equals("+x")){
                ori = next;
                continue;
            }else if (ori.equals("-x")) {
                ori  = (next.charAt(0) == '+' ? "-" : "+") + next.charAt(1);
                continue;
            }else if (next.charAt(1)== 'y'){
                if (ori.charAt(1) == 'y'){
                    if (ori.charAt(0) == next.charAt(0))
                        ori = "-x";
                    else
                        ori = "+x";
                }
            }else if (next.charAt(1) == 'z'){
                if (ori.charAt(1) == 'z'){
                    if (ori.charAt(0) == next.charAt(0))
                        ori = "-x";
                    else
                        ori = "+x";
                }
            }
        }

        System.out.print(ori);
        sc.close();
    }
}
