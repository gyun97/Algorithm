import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int right = 0; right < N; right++) {
            hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right], 0) + 1);

            while (hashMap.size() > 2) {
                hashMap.replace(fruits[left], hashMap.get(fruits[left]) - 1);
                if (hashMap.get(fruits[left]) == 0) {
                    hashMap.remove(fruits[left]);
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        sb.append(answer);
        System.out.println(sb);

    }

}
