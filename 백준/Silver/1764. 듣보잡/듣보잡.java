import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // LinkedHashSet<>()은 입력 순서대로 원소 순서 보장
        Set<String> a = new LinkedHashSet<>();  // 듣
        while (N-- > 0) {
            a.add((br.readLine()));
        }

        Set<String> b = new LinkedHashSet<>();  // 보
        while (M-- > 0) {
            b.add((br.readLine()));
        }

        a.retainAll(b);
        int num = (a.size());

        Set<String> answer = new TreeSet<>(a); // TreeSet은 이진 탐색 트리로 순서 자동 정렬

        System.out.println(num);

        Iterator<String> iterator = answer.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}