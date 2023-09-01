
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = arr[0];
       for (int j = 1; j < N; j++){
           if (min > arr[j]){
               min = arr[j];
           }
       }

        int max= arr[0];
        for (int k = 1; k < N; k++){
            if (max < arr[k]){
                max = arr[k];
            }
        }
        sb.append(min + " ").append(max);
        System.out.println(sb);
    }
}