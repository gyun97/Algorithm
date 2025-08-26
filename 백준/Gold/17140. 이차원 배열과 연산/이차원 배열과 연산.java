import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int r, c, k, time;
    static int[][] A;
    static int rowSize = 3, colSize = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // A[r - 1][c - 1] = k가 되기 위한 최소 시간

        A = new int[101][101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(simulate());
    }


    private static int simulate() {
        for (int time = 0; time <= 100; time++) {
            if (A[r - 1][c - 1] == k) return time;
            if (rowSize >= colSize) rowOperation();
            else colOperation();

        }
        return -1;
    }

    // R 연산: 행 기준
    private static void rowOperation() {
        int maxCol = 0;
        int[][] newA = new int[101][101];
        for (int row = 0; row < rowSize; row++) {
            List<int[]> list = countAndSort(A[row], colSize);

            int idx = 0;
            for (int[] p : list) {
                if (idx >= 100) break; // 최대 100까지만
                newA[row][idx++] = p[0];
                if (idx >= 100) break;
                newA[row][idx++] = p[1];
            }
            maxCol = Math.max(maxCol, idx);
        }
        A = newA;
        colSize = maxCol;
    }

    // C 연산: 열 기준
    private static void colOperation() {
        int maxRow = 0;
        int[][] newA = new int[101][101];

        for (int j = 0; j < colSize; j++) {
            int[] col = new int[rowSize];
            for (int i = 0; i < rowSize; i++) {
                col[i] = A[i][j];
            }

            List<int[]> list = countAndSort(col, rowSize);
            int idx = 0;
            for (int[] p : list) {
                if (idx >= 100) break; // 최대 100까지만
                newA[idx++][j] = p[0];
                if (idx >= 100) break;
                newA[idx++][j] = p[1];
            }
            maxRow = Math.max(maxRow, idx);
        }
        A = newA;
        rowSize = maxRow;
    }

    // (숫자, 등장 횟수) 카운트 후 정렬
    private static List<int[]> countAndSort(int[] arr, int size) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) continue;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }

        Collections.sort(list, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
        
        return list;
    }

}


