import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int big = Math.max(N,K);
        int small = Math.min(N,K);

        for (int i =1; i <= big; i++){
            if (big % i == 0){
                count += 1;
                if (count == K){
                    bw.write(String.valueOf(i));
                }
            }
        }
        if (count < K){
            bw.write(String.valueOf(0));
        }
        br.close();
        bw.flush();
        bw.close();

    }
}