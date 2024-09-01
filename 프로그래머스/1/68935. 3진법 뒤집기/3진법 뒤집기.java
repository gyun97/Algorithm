class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        // 3진법 변환
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        // 뒤집힌 3진법 값
        String string = sb.toString();
        System.out.println("Reversed Ternary: " + string);

        int result = 0;

        // 10진법으로 변환
        for (int i = 0; i < string.length(); i++) {
            result += Integer.parseInt(String.valueOf(string.charAt(i))) * Math.pow(3, string.length() - 1 - i);
            System.out.println("Intermediate Result: " + result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 125;
        int result = sol.solution(n);
        System.out.println("Final Result: " + result);
    }
}
