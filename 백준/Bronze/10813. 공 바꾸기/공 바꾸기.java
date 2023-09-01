import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int x = 0; x < N; x++){
            arr[x] = x+1;
        }

        for (int y = 0; y < M; y++){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int temp_i = arr[i-1];
            int temp_j = arr[j-1];

            arr[i-1] = temp_j;
            arr[j-1] = temp_i;
        }

        for (int a : arr){
            System.out.print(a +" ");
        }
    }
}