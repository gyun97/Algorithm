import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int countKnow = Integer.parseInt(st.nextToken());

        int truthRoot = 0; // 진실 아는 그룹의 루트

        if (countKnow > 0) {
            truthRoot = Integer.parseInt(st.nextToken());
            for (int i = 1; i < countKnow; i++) {
                int person = Integer.parseInt(st.nextToken());
                union(truthRoot, person);
            }
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());
            if (peopleCount > 0) {
                int first = Integer.parseInt(st.nextToken());
                parties.get(i).add(first);
                for (int j = 1; j < peopleCount; j++) {
                    int next = Integer.parseInt(st.nextToken());
                    parties.get(i).add(next);
                    union(first, next);
                }
            }
        }

        int answer = 0;

        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (countKnow > 0 && find(person) == find(truthRoot)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
