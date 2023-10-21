import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] grades = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grades);

        for (int i = 0; i < N - 1; i++) {
            bw.write(Integer.toString(grades[i]));
            bw.write(' ');
        }
        bw.write(Integer.toString(grades[N - 1]));
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
