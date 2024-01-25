import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            hashMap.put(br.readLine(), 0);
        }

        for (int j = 0; j < M; j++) {
            if (hashMap.containsKey(br.readLine())){
                count++;
            }
            

        }

        sb.append(count);
        System.out.println(sb);


    }
}







