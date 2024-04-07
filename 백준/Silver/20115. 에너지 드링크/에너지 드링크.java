import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] drinks = new int[N];

        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drinks);

        double sum = 0;
        
        for (int i = 0; i < N - 1; i++) {
            sum += (double) drinks[i] / 2;
        }

        double answer = sum + drinks[N-1];
        System.out.println(answer);




    }
}