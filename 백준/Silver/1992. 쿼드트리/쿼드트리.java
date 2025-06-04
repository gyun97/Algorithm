import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        video = new char[N][N];

        for (int i = 0; i < N; i++) {
            video[i] = br.readLine().toCharArray();
        }

        compress(0, 0, N);
        System.out.println(sb.toString());
    }

    private static void compress(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            sb.append(video[x][y]);
            return;
        }

        int half = size / 2;

        sb.append("(");
        compress(x, y, half); // 1사분면
        compress(x, y + half, half); // 2사분면
        compress(x + half, y, half); // 3사분면
        compress(x + half, y + half, half); // 4사분면
        sb.append(")");

    }

    private static boolean isSameColor(int x, int y, int size) {
        char first = video[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (first != video[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
