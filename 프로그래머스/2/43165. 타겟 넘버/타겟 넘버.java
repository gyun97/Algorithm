class Solution {

    static int count;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0); // depth: 현재 트리의 깊이, sum: 현재까지의 합
        return count;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        // base case(재귀 탈출 조건)
        if (depth == numbers.length) { // 트리의 끝에 도달했을 때
            if (target == sum) { // 현재까지의 합이 목표값과 같다면
                count++; // 경우의 수 증가
            }
            return; // 재귀 종료
        }

        // recursive call(재귀 호출)
        dfs(numbers, target, depth + 1, sum + numbers[depth]); // 다음 정수를 더한 경우
        dfs(numbers, target, depth + 1, sum - numbers[depth]); // 다음 정수를 뺀 경우

    }
}