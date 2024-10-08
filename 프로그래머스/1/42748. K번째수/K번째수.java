    import java.util.Arrays;

    /**
     * 1. commands의  배열을 하나 꺼내  첫 번째 원소(i) ~ 두 번째 원소(j)까지 array를 자른다.
     * 2. 이후 자른 배열을 정렬한다.
     * 3. 해당 배열에서 k번째 수를 구해 result 배열에 담는다.
     * 4. 해당 과정을 commands의 모든 원소에 적용할 때까지 반복한다.
     */

    class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] result = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int fromIdx = commands[i][0] - 1;
                int toIdx = commands[i][1];
                int[] newArray = Arrays.copyOfRange(array, fromIdx, toIdx);
                Arrays.sort(newArray);
                result[i] = newArray[commands[i][2] - 1];

            }
            return result;

        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] array = {1, 5, 2, 6, 3, 7, 4};
            int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
            sol.solution(array, commands);
        }

    }