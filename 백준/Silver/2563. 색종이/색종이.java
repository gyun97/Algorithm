import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] drawing_paper = new int[100][100];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = w; j < 10 + w; j++){
                for (int k = h; k < 10 + h; k++){
                    drawing_paper[j][k] = 1;
                }
            }
        }

        int area = 0;

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (drawing_paper[i][j] == 1){
                    area++;
                }
            }
        }
        br.close();
        bw.write(String.valueOf(area));
        bw.flush();
        bw.close();

    }
}
