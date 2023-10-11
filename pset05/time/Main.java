import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reminder {
    int id, interval, nextAlert;

    Reminder(int id, int interval) {
        this.id = id;
        this.interval = interval;
        this.nextAlert = interval;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Reminder> reminders = new ArrayList<>();

        // Read reminders
        while (true) {
            String line = sc.nextLine();
            if (line.charAt(0) == '#') {
                break;
            }
            String[] parts = line.split(" ");
            int id = Integer.parseInt(parts[1]);
            int interval = Integer.parseInt(parts[2]);
            reminders.add(new Reminder(id, interval));
        }

        int N = Integer.parseInt(sc.nextLine());

        // Process alerts
        for (int i = 0; i < N; i++) {
            reminders.sort((r1, r2) -> {
                if (r1.nextAlert != r2.nextAlert) {
                    return Integer.compare(r1.nextAlert, r2.nextAlert);
                }
                return Integer.compare(r1.id, r2.id);
            });
            
            Reminder r = reminders.get(0);
            System.out.println(r.id);
            r.nextAlert += r.interval;
        }
    
    }
}
