class Solution {

    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1); // 결과 배열의 크기
        int[] result = new int[size]; // 결과 배열

        /*
        n = 3, left = 2, right = 5
        1 2 3
        2 2 3
        3 3 3

        [3, 2, 2, 3]
         */

        // (i, j) 위치의 값은 max(i, j) + 1 => 행과 열 번호만 알면 해당 위치의 값은 쉽게 구할 수 있음

        // n * n 2차원 배열의 특정 요소 (행 번호, 열 번호)를 1차원 배열의 인덱스로 표현하면, 각 인덱스 = 행 번호 * n(행 크기) + 열 번호
        // 행 : 해당 인덱스 / n => 각 행에는 n개의 요소가 포함되어 있기 때문
        // 열 : 해당 인덱스 % n => 각 행에는 n개의 요소가 포함되어 있기 때문

        for (int index = 0; index < size; index++) { // 결과 배열의 크기만큼 반복, 결과 배열 하나씩 채워나감
            long i = (left + index) / n; // 행 번호 => ex) index = 3이면, 3 / 3 = 1이므로 이 값은 두 번째 행(i = 1)에 속함
            long j = (left + index) % n; // 열 번호 => ex) index = 3이면, 3 % 3 = 0이므로 이 값은 첫 번째 열(j = 0)에 속함

            result[index] = (int)(Math.max(i, j) + 1); // 구한 행, 열 번호로 해당 위치의 값 계산
        }

        return result;
    }
}
