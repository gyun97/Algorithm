class Solution {
    public long[] solution(int x, int n) {

        long[] answer = new long[n];
        long j = 0;

        for (int i = 0; i < n; i++) {
            j++;
            answer[i] = x * j;
        }

        return answer;
        
    }
}