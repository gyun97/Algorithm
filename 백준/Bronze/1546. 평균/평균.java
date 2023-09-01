import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        double[] score_list = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            score_list[i] = score;
        }
        double max = Arrays.stream(score_list).max().getAsDouble();

        for (int j = 0; j < score_list.length; j++) {
            score_list[j] = score_list[j] / max * 100;
        }

        double sum = 0;

        for (int k = 0; k < score_list.length; k++) {
            sum += score_list[k];
        }

        sb.append(sum/score_list.length);
        System.out.println(sb);
        br.close();
    }
}