import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //최댓값을 저장할 변수 선언
        int max = -1;
        //행과 열 번호를 저장할 변수 선언
        String row_col = "";

        //행과 열에 입력값을 넣어줄 for문
        for(int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++) {
                int N = Integer.parseInt(st.nextToken());

                if(max < N) {
                    max = N;
                    row_col = String.valueOf(i) + " " + String.valueOf(j);
                }
            }
        }
        System.out.println(max);
        System.out.println(row_col);

    }

}
