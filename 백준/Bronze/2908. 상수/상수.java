import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        String A = st.nextToken();
        String B = st.nextToken();

        String[] A_arr = A.split("");
        String[] B_arr = B.split("");
        String reversed_A = "";
        String reversed_B = "";

        for (int i = 2; i >= 0; i--){
            reversed_A += (A_arr[i]);
        }

        for (int j = 2; j >= 0; j--){
            reversed_B += B_arr[j];
        }

         int real_A  = Integer.parseInt(reversed_A);
         int real_B  = Integer.parseInt(reversed_B);

         int max = Math.max(real_A, real_B);

         br.close();
         sb.append(max);
         System.out.println(sb);
    }
           }