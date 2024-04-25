import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 1;

            HashMap<String, Integer> hashMap = new HashMap<>();

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String cloth = st.nextToken();
                String kind = st.nextToken();
                hashMap.put(kind, hashMap.getOrDefault(kind, 0) + 1);

            }

            for (Integer value : hashMap.values()) {
                count *= (value + 1);
            }
            sb.append(count - 1).append("\n");
        }

        System.out.println(sb);


    }
}