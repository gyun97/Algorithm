class Solution {
    public int solution(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        String string = sb.toString();
//        System.out.println(string);
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result += (int) (Integer.parseInt(String.valueOf(string.charAt(i)))  * Math.pow(3, string.length() - 1 - i));
//            System.out.println(result);
        }
        return result;


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 125;
        sol.solution(n);
    }
}