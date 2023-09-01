import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Arrays.fill(arr, 0, N, 0); // 배열의 인덱스 0부터 M-1까지 0으로 채움

        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int y = i-1; y < j; y++){
                arr[y] = k;
            }
        }
        for (int z = 0; z < N; z++){
            System.out.print(arr[z] + " ");
        }
    }
}