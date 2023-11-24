import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr_N = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());

        }

        int M = Integer.parseInt(br.readLine());
        int[] arr_M = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < M; j++) {
            arr_M[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_N);

        for (int target : arr_M) {
            int first_idx = 0;
            int last_idx = N - 1;
            boolean target_exist = false;

            while (last_idx >= first_idx) {
                int middle_idx = (first_idx + last_idx) / 2;

                if (target == arr_N[middle_idx]) {
                    sb.append(1).append("\n");
                    target_exist = true;
                    break;
                }
                else if (target > arr_N[middle_idx]) {
                    first_idx = middle_idx + 1;

                }
                else {
                    last_idx = middle_idx - 1;
                }

            }

            if (!target_exist) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }
}





