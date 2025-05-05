import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        backtracking(0);
        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
                bw.write(arr[i] + " ");

            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            backtracking(depth + 1);
        }

    }


}
