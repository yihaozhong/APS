import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ini = sc.nextLine().split(" ");
        double loanOwed = Double.parseDouble(ini[2]);
        double loanPay = loanOwed/Integer.parseInt(ini[0]);
        double downPay = Double.parseDouble(ini[1]);
        
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < Integer.parseInt(ini[3]); i++){
            String[] loan = sc.nextLine().split(" ");
            map.put(Integer.parseInt(loan[0]), Double.parseDouble(loan[1]));    
        }
        double currRate = map.get(0);
        double carVal = (loanOwed + downPay) * (1-currRate);
        int month = 0;
        while (carVal <= loanOwed){
            month += 1;
            if (map.containsKey(month))
                currRate = map.get(month);
            carVal *= (1-currRate);
            loanOwed -= loanPay;
        }
        System.out.println(month + (month == 1 ? " month" : " months"));
        sc.close();

    }
}
