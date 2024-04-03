import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        ArrayList<Integer> arrayList = new ArrayList<>();



        while (st.hasMoreTokens()) {
            StringTokenizer newSt = new StringTokenizer(st.nextToken(), "+");
            int sum = 0;
            while (newSt.hasMoreTokens()) {
                sum += Integer.parseInt(newSt.nextToken());
            }
            arrayList.add(sum);

        }

//        arrayList.parallelStream().forEach(i -> System.out.println(i));

        int answer = arrayList.get(0);
        for (int j = 1; j < arrayList.size(); j++) {
            answer -= arrayList.get(j);
        }
        System.out.println(answer);
        
    }
}