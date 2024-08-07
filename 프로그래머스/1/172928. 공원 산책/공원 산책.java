import java.util.jar.JarEntry;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int H = park.length; // 세로
        int W = park[0].length(); // 가로

        int x = -1; // 시작 X 좌표
        int y = -1; // 시작 Y 좌표


        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf('S');
                break;
            }
        }


        for (String route : routes) {
            String[] array = route.split(" ");
            String dir = array[0];
            int dis = Integer.parseInt(array[1]);
            Integer currentX = x;
            Integer currentY = y;
            boolean flag = true;

            switch (dir) {
                case "E" :
                    for (int i = 0; i < dis; i++) {
                        currentY++;
                        if (currentY >= W || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) y = currentY;
                    break;


                case "W" :
                    for (int i = 0; i < dis; i++) {
                        currentY--;
                        if (currentY < 0 || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) y = currentY;
                    break;


                case "S" :
                    for (int i = 0; i < dis; i++) {
                        currentX++;
                        if (currentX >= H || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) x = currentX;
                    break;


                case "N" :
                    for (int i = 0; i < dis; i++) {
                        currentX--;
                        if (currentX < 0 || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) x = currentX;
                    break;

            }

        }
        answer[0] = x;
        answer[1] = y;

        return answer;

    }
}