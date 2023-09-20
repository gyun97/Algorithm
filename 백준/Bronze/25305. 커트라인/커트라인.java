import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr, Collections.reverseOrder());

        sb.append(arr.get(k-1));
        System.out.println(sb);
    }

}