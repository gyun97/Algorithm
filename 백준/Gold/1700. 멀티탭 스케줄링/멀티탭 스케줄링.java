import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 콘센트 개수
        int K = Integer.parseInt(st.nextToken()); // 전기용품 사용 순서 길이

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> sockets = new HashSet<>(); // 현재 꽂혀 있는 전기용품
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int current = order[i];

            // 이미 꽂혀 있는 경우 패스
            if (sockets.contains(current)) {
                continue;
            }

            // 콘센트에 여유가 있는 경우
            if (sockets.size() < N) {
                sockets.add(current);
                continue;
            }

            // 콘센트가 가득 찬 경우, 뺄 전기용품 찾기
            int idxToRemove = -1;
            int farthestIdx = -1;

            for (int plugged : sockets) {
                int nextUse = Integer.MAX_VALUE; // 앞으로 사용되지 않는 경우를 대비

                for (int j = i + 1; j < K; j++) {
                    if (order[j] == plugged) {
                        nextUse = j;
                        break;
                    }
                }

                // 가장 나중에 다시 사용되는 전기용품 찾기
                if (nextUse > farthestIdx) {
                    farthestIdx = nextUse;
                    idxToRemove = plugged;
                }
            }

            // 전기용품 교체
            sockets.remove(idxToRemove);
            sockets.add(current);
            answer++; // 플러그 교체 횟수 증가
        }

        System.out.println(answer);
    }
}
