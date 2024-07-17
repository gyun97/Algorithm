class Solution {
    public int solution(int a, int b, int n) {

        // (n - a의 최대 배수) + (n // a * b)한 값을 반복하여 누적 합
//        a = 4
//        b = 2
//        n = 1 +
//        sum = 0

        int sum = 0;
        while (n >= a) {
            sum += ((n / a) * b);
            n = (n - ((n / a) * a)) + ((n / a) * b);

        }
        return sum;



    }
}