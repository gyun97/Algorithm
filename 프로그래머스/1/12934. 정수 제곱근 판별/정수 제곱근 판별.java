class Solution {
    public long solution(long n) {


        double x = Math.sqrt(n);
        double answer = x - (int) x == 0 ? Math.pow(x + 1, 2) : -1;
        return (long) answer;

    }
}