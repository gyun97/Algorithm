import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));


            int count = 0;
            int prevEnd= 0;

            for (int[] meeting : meetings) {
                int newStart = meeting[0];
                int newEnd = meeting[1];
                if (newStart >= prevEnd) {
                    count++;
                    prevEnd = newEnd;
                }
            }

            System.out.println(count);
        }


    }
