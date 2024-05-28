import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> setArr = new TreeSet<>();

        Collections.addAll(setArr, arr);


        HashMap<Integer, Integer> hashArr = new LinkedHashMap();

        int j = -1;
        for (Integer i : setArr) {
            j++;
            hashArr.put(i, j);
        }


        for (Integer i : arr) {
            sb.append(hashArr.get(i) + " ");
        }
        System.out.println(sb);



        }


    }








