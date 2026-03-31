import java.util.*;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] game_board, int[][] table) {

        int n = game_board.length;

        boolean[][] visitedBoard = new boolean[n][n];
        boolean[][] visitedTable = new boolean[n][n];

        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> puzzles = new ArrayList<>();

        // 1. 빈칸 추출 (0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    blanks.add(bfs(game_board, visitedBoard, i, j, 0));
                }
            }
        }

        // 2. 퍼즐 추출 (1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    puzzles.add(bfs(table, visitedTable, i, j, 1));
                }
            }
        }

        int answer = 0;
        boolean[] used = new boolean[puzzles.size()];

        // 3. 매칭
        for (List<int[]> blank : blanks) {

            for (int i = 0; i < puzzles.size(); i++) {

                if (used[i]) continue;

                List<int[]> puzzle = puzzles.get(i);

                if (match(blank, puzzle)) {
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }

        return answer;
    }

    // BFS로 도형 추출
    private List<int[]> bfs(int[][] board, boolean[][] visited, int x, int y, int target) {

        int n = board.length;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;
        shape.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (!visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    shape.add(new int[]{nx, ny});
                }
            }
        }

        return normalize(shape);
    }

    // 정규화 (좌상단 기준 이동 + 정렬)
    private List<int[]> normalize(List<int[]> shape) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[0] - minX, p[1] - minY});
        }

        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return result;
    }

    // 회전
    private List<int[]> rotate(List<int[]> shape) {

        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[1], -p[0]});
        }

        return normalize(result);
    }

    // 도형 비교 (회전 포함)
    private boolean match(List<int[]> blank, List<int[]> puzzle) {

        for (int i = 0; i < 4; i++) {

            puzzle = rotate(puzzle);

            if (isSame(blank, puzzle)) {
                return true;
            }
        }

        return false;
    }

    // 완전 동일 비교
    private boolean isSame(List<int[]> a, List<int[]> b) {

        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] ||
                a.get(i)[1] != b.get(i)[1]) {
                return false;
            }
        }

        return true;
    }
}