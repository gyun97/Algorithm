import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int changes[] = {25, 10, 5, 1};

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            for (int j = 0; j < changes.length; j++) {
                int count = C/changes[j];
                System.out.print(count + " ");
                C = C%changes[j];
            }
            System.out.println();
        }

    }
}