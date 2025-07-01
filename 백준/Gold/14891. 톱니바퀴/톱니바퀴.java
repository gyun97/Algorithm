import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] wheels = new char[5][8];

        for (int i = 1; i <= 4; i++) {
            wheels[i] = br.readLine().toCharArray();
        }

//        System.out.println(Arrays.deepToString(wheels));

        int K = Integer.parseInt(br.readLine());

        int answer = 0;


        for (int i = 0; i < K; i++) {

            int[] rotate = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotate[wheelNum] = dir;

            // 기준 톱니로부터 오른쪽 톱니들의 회전 방향 파악
            for (int j = wheelNum; j < 4; j++) {
                if (wheels[j][2] != wheels[j + 1][6]) {
                    if (rotate[j] == 1) rotate[j + 1] = -1;
                    if (rotate[j] == -1) rotate[j + 1] = 1;
                }
            }

            for (int j = wheelNum; j > 1; j--) {
                if (wheels[j][6] != wheels[j - 1][2]) {
                    if (rotate[j] == 1) rotate[j - 1] = -1;
                    if (rotate[j] == -1) rotate[j - 1] = 1;
                }
            }

//            System.out.println(Arrays.toString(rotate));

            for (int j = 1; j <= 4; j++) {
                int rotateDir = rotate[j];

                if (rotateDir == 0) continue;

                char temp0 = wheels[j][0];
                char temp1 = wheels[j][1];
                char temp2 = wheels[j][2];
                char temp3 = wheels[j][3];
                char temp4 = wheels[j][4];
                char temp5 = wheels[j][5];
                char temp6 = wheels[j][6];
                char temp7 = wheels[j][7];

                // 해당 톱니바퀴의 회전 방향이 반시계방향인 경우
                if (rotateDir == - 1) {
                    wheels[j][0] = temp1;
                    wheels[j][1] = temp2;
                    wheels[j][2] = temp3;
                    wheels[j][3] = temp4;
                    wheels[j][4] = temp5;
                    wheels[j][5] = temp6;
                    wheels[j][6] = temp7;
                    wheels[j][7] = temp0;
                }
                // 해당 톱니바퀴의 회전 방향이 시계방향인 경우
                else if (rotateDir == 1) {
                    wheels[j][0] = temp7;
                    wheels[j][1] = temp0;
                    wheels[j][2] = temp1;
                    wheels[j][3] = temp2;
                    wheels[j][4] = temp3;
                    wheels[j][5] = temp4;
                    wheels[j][6] = temp5;
                    wheels[j][7] = temp6;
                }

            }

        }

        if (wheels[1][0] == '1') answer += 1;
        if (wheels[2][0] == '1') answer += 2;
        if (wheels[3][0] == '1') answer += 4;
        if (wheels[4][0] == '1') answer += 8;

        System.out.println(answer);

    }
}
