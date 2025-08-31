import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 감소하는 수 생성
        for (int i = 0; i < 10; i++) {
            backtracking(i, i);
        }

        // 오름차순 정렬
        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    // 현재 숫자(num), 마지막 자리수(lastDigit)
    private static void backtracking(long num, int lastDigit) {
        list.add(num);
        for (int i = 0; i < lastDigit; i++) {
            backtracking(num * 10 + i, i);
        }
    }
}
