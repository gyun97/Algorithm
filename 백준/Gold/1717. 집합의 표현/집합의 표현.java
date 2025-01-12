import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 집합의 개수
        int M = Integer.parseInt(st.nextToken()); // 질문의 개수

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cond = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cond == 0) union(a, b);
            else {
                boolean checkedSame = checkSame(a, b);// 두 원소 같은지 
                if (checkedSame) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        // 대표 노드를 찾아서 연결하기
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[a] = b; // 두 노드 연
        }

    }



    private static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);

    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        return false;
    }
}





