class Solution {
    public int solution(int left, int right) {

        int sum = 0;

        for (int i = left; i <= right; i++) {
            double a = Math.sqrt(i);
            if (a % (int) a == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }

        return sum;


    }
}
