class Solution {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int x = -1;
        int y = -1;

        int H = park.length; // 세로
        int W = park[0].length();  // 가로

        // Find starting position 'S'
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1) break;  // Stop if 'S' is found
        }

        // Process routes
        for (String route : routes) {
            String[] array = route.split(" ");
            String dir = array[0];
            int dis = Integer.parseInt(array[1]);
            int currentX = x;
            int currentY = y;
            boolean flag = true;

            switch (dir) {
                case "E":
                    for (int j = 0; j < dis; j++) {
                        currentY++;
                        if (currentY >= W || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) y = currentY;  // Update y if move is valid
                    break;

                case "W":
                    for (int j = 0; j < dis; j++) {
                        currentY--;
                        if (currentY < 0 || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) y = currentY;  // Update y if move is valid
                    break;

                case "S":
                    for (int j = 0; j < dis; j++) {
                        currentX++;
                        if (currentX >= H || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) x = currentX;  // Update x if move is valid
                    break;

                case "N":
                    for (int j = 0; j < dis; j++) {
                        currentX--;
                        if (currentX < 0 || park[currentX].charAt(currentY) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) x = currentX;  // Update x if move is valid
                    break;
            }
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
