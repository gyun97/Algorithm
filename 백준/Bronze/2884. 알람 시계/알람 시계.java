import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M >= 45) {
            sb.append(H + " ").append(M - 45);
            System.out.println(sb);
        } else {
            if (H == 0) {
                sb.append(23 + " ").append(60 - (45 - M));
                System.out.println(sb);
            } else {
                sb.append(H - 1 + " ").append(60 - (45 - M));
                System.out.println(sb);
            }
        }
    }
}