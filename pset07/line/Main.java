import java.util.*;

public class Main {
    static class Element {
        int index;
        int group;

        public Element(int index, int group) {
            this.index = index;
            this.group = group;
        }
    }

    private final Map<Integer, Integer> indexToGroupMap = new HashMap<>();
    private final Map<Integer, LinkedList<Element>> groupMap = new HashMap<>();
    private final LinkedList<Element> queue = new LinkedList<>();

    public void push(int index) {
        int group = indexToGroupMap.getOrDefault(index, -1);
        Element element = new Element(index, group);

        LinkedList<Element> groupList = groupMap.get(group);
        if (groupList == null || groupList.isEmpty()) {
            queue.addLast(element);
        } else {
            int lastElementIndex = queue.indexOf(groupList.getLast());
            queue.add(lastElementIndex + 1, element);
        }

        groupMap.computeIfAbsent(group, k -> new LinkedList<>()).add(element);
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Element element = queue.removeFirst();
        groupMap.get(element.group).remove(element);
        return element.index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main groupQueue = new Main();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] groupInfo = scanner.nextLine().split(" ");
            int k = Integer.parseInt(groupInfo[0]);
            for (int j = 1; j <= k; j++) {
                int index = Integer.parseInt(groupInfo[j]);
                groupQueue.indexToGroupMap.put(index, i);
            }
        }

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equals("Shutdown")) {
                break;
            } else if (command.startsWith("Push")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                groupQueue.push(index);
            } else if (command.equals("Pop")) {
                System.out.println(groupQueue.pop());
            }
        }

        scanner.close();
    }
}
