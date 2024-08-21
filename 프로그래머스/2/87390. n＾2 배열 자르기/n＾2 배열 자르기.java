class Solution {

    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] result = new int[size];

        for (int index = 0; index < size; index++) {
            long i = (left + index) / n ; // 행
            long j = (left + index) % n ; // 열
            result[index] = (int)(Math.max(i, j) + 1);
        }

        return result;
    }
}
