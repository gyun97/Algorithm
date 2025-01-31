import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i][0] = start;
            meetings[i][1] = end;
        }


        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
//        Arrays.sort(meetings, ((o1, o2) -> {
//            if (o1[1] == o2[1]) {
//                return Integer.compare(o1[0], o1[0]);
//            }
//            return Integer.compare(o1[1], o2[1]);
//        } ));

        int curEndTime = 0;
        int count = 0;
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            if (curEndTime <= startTime) {
                curEndTime = endTime;
                count++;
            }
        }

//        System.out.println(Arrays.deepToString(meetings));
        sb.append(count);
        System.out.println(sb);
    }

}
