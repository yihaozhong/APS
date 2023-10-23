import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // an computer is interconnected if they are directly connected or if they
        // interconnect with the same computer
        // each connection is bidirectional
        // an computer is direcctly connect to itself
        // write a program to count the num of postive and negative number of to the
        // question
        // is computer A interconnected with computer B

        // input, first line is the number of computers, the following line are
        // c ci cj, means computer ci and cj are connected
        // q ci cj, means query if computer ci and cj are connected
        // output, print the number of positive and negative answer after all the query,
        // sum up the number of positive and negative answer

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // union find
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // each computer is connected to itself
            size[i] = 1;
        }

        int positive = 0;
        int negative = 0;
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            String operation = st.nextToken();
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            if (operation.equals("c")) {
                union(parent, i, j, size);
            } else if (operation.equals("q")) {
                if (find(parent, i) == find(parent, j)) {
                    positive++;
                } else {
                    negative++;
                }
            }
        }
        System.out.print(positive + "," + negative + "\n");
    }

    // use union find
    public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // with size
    public static void union(int[] parent, int i, int j, int[] size) {
        int iRoot = find(parent, i);
        int jRoot = find(parent, j);
        if (iRoot == jRoot) {
            return;
        }
        if (size[iRoot] < size[jRoot]) {
            parent[iRoot] = jRoot;
            size[jRoot] += size[iRoot];
        } else {
            parent[jRoot] = iRoot;
            size[iRoot] += size[jRoot];
        }
    }

}
