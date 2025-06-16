import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int minDist = 1;
        int maxDist = homes[N - 1] - homes[0];

        while (minDist <= maxDist) {
            int midDist = (minDist + maxDist) / 2;
            if (canInstall(midDist) >= C) {
                minDist = midDist + 1;
            } else {
                maxDist = midDist - 1;
            }
        }

        System.out.println(maxDist);

    }

    private static int canInstall(int midDist) {
        int lastLocated = homes[0];
        int count = 1;

        for (int i = 1; i < homes.length; i++) {
            int curHome = homes[i];
            if (lastLocated + midDist <= curHome) {
                count++;
                lastLocated = homes[i];
            }
        }
        return count;
    }

}




