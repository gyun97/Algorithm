class Solution {
    public long solution(int n) {

//        long[] dp = new long[n + 1]; 메모리 부족으로 tc 1번 런타임 에러?
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }

}