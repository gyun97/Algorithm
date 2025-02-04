import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] grades = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int docGrade = Integer.parseInt(st.nextToken()); // 서류 성적
                int intGrade = Integer.parseInt(st.nextToken()); // 면접 성적
                grades[i][0] = docGrade;
                grades[i][1] = intGrade;
            }

            Arrays.sort(grades, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
//            System.out.print(Arrays.deepToString(grades));

            int answer = 1;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(grades[0][1]);

            for (int i = 1; i < N; i++) {
                int docGrade = grades[i][0];
                int intGrade = grades[i][1];
                pq.offer(intGrade);
                if (pq.peek() == intGrade) {
                    answer += 1;
                }
            }
            System.out.println(answer);
        }


    }

}
