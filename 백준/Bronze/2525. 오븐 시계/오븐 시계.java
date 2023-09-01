import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        if (B+C >= 60){
            A = A + (B+C)/60;
            B = (B+C)%60;

            if (A >= 24){
                A = A - 24;
            }
        }
        else{
            B = B + C;
        }
        System.out.printf("%d %d", A, B);
    }
}