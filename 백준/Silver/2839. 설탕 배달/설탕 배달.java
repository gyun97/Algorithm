import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                sb.append(count);
                break;
            } else {
                N -= 3;
                count += 1;
                if (N < 0) {
                    sb.append(-1);
                    break;
                }

            }
        }
        System.out.println(sb);
    }
}