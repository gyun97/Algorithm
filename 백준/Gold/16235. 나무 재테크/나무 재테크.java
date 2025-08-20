import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Tree {
    int age; // 나이

    public Tree(int age) {
        this.age = age;
    }

}

public class Main {
    static int N, M, K;
    static int[][] A;
    static List<Tree>[][] trees;
    static int[][] food;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행, 열
        M = Integer.parseInt(st.nextToken()); // 나무의 개수
        K = Integer.parseInt(st.nextToken()); // 지난 연도 수

        A = new int[N + 1][N + 1]; // 겨울에 로봇에 의해 각 칸에 추가되는 양분의 양을 나타내는 배열
        trees = new List[N + 1][N + 1]; // 각 땅에 심어져있는 나무의 정보
        food = new int[N + 1][N + 1]; // 각 땅의 현재 양분의 양

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                trees[i][j] = new ArrayList<>();
                food[i][j] = 5;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 나무의 행
            int y = Integer.parseInt(st.nextToken()); // 나무의 열
            int z = Integer.parseInt(st.nextToken()); // 나무의 나이

            trees[x][y].add(new Tree(z));
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                Collections.sort(trees[i][j], Comparator.comparing(t -> t.age)); // 나무들 나이 순으로 오름차순 정렬
//            }
//        }

        while (K-- > 0) {
            springAndSummer();
            fall();
            winter();
        }

        // K년 지난 후 살아남은 나무의 수 출력하기
        System.out.println(countTree());
    }


    // 살아남은 나무 수 계산
    private static int countTree() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                List<Tree> cur = trees[i][j];
                sum += cur.size();
            }
        }
        return sum;
    }

    // 봄과 여름 처리
    private static void springAndSummer() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (trees[x][y].isEmpty()) continue;

                List<Tree> curTrees = trees[x][y];
//                Collections.sort(trees[x][y], Comparator.comparing(t -> t.age)); // 나무들 나이 순으로 오름차순 정렬
                List<Tree> aliveTrees = new ArrayList<>(); // 처리된 살아있는 트리들 임시 공간

//                for (Tree tree : curTrees) {
//                    if (tree.age <= food[x][y]) { // 만약 양분이 아직 충분하다면
//                        food[x][y] -= tree.age; // 현재 나무가 먹은만큼 양분 빼기
//                        tree.age++; // 현재 나무 나이 + 1
//                        aliveTrees.add(tree);
//                    } else { // 양분이 아직 충분하지 않다면
////                        food[x][y] += tree.age / 2; // 죽은 나이의 절반만큼 양분화
//                    }
//                }

                for (int i = 0; i < curTrees.size(); i++) {
                    if (curTrees.get(i).age <= food[x][y]) { // 만약 양분이 아직 충분하다면
                        food[x][y] -= curTrees.get(i).age; // 현재 나무가 먹은만큼 양분 빼기
                        curTrees.get(i).age++; // 현재 나무 나이 + 1
                        aliveTrees.add(curTrees.get(i));
                    } else {
                        for (int j = i; j < curTrees.size(); j++) {
                            food[x][y] += curTrees.get(j).age / 2;
                        }
                        break;
                    }
                }
                
                trees[x][y] = aliveTrees;
            }
        }
    }

    // 가을 처리
    private static void fall() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (trees[x][y].isEmpty()) continue;

                List<Tree> curTree = trees[x][y];
                for (Tree tree : curTree) {
                    if (tree.age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (0 < nx && nx <= N && 0 < ny && ny <= N) { // 땅의 범위를 벗어나지 않는다면
                                trees[nx][ny].add(0, new Tree(1)); // 주변 8칸에 나이가 1인 나무들을 리스트 맨 앞에 추가(정렬 줄이기)
                            }
                        }
                    }
                }
            }
        }

    }

    // 겨울 처리
    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                food[i][j] += A[i][j];
            }
        }
    }
}
