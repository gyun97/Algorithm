import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int m = 1;
        int n = 1;

        for (int i = N; i > N - K; i--) {
            m *= i;

        }

        for (int j = 1; j <= K; j++) {
            n *= j;
        }

        System.out.println(m/n);

    }

}





