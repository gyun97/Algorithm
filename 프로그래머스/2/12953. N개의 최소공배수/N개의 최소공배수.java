class Solution {
    // 최대공약수(GCD) 함수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 함수
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int solution(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }

        return result;
    }
}
