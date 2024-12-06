import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        long answer = Long.parseLong(strings[0]) - Long.parseLong(strings[1]);
        System.out.println(Math.abs(answer));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int answerCount = 0;
//
//        String[][] board = new String[N][M];
//
//        for (int i = 0; i < N; i++) {
//                String[] split = br.readLine().split("");
//            for (int j = 0; j < M; j++) {
//                board[i][j] = split[j];
//            }
//        }
//        System.out.println(Arrays.deepToString(board));
//
//        /**
//         * 경우1 : W로 시작
//         * 경우2: B로 시작
//         */
//
//        if (board[0][0].equals("W")) {
//
//
//        }

    }

}