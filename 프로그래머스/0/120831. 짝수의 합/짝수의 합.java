import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).sum();
    }

    public static void main(String[] args) {
        int n = 10;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}