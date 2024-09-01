class Solution {
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {  // 공백 처리
                result.append(' ');
            } else if (Character.isUpperCase(c)) {  // 대문자 처리
                char shifted = (char) ((c - 'A' + n) % 26 + 'A');
                result.append(shifted);
            } else if (Character.isLowerCase(c)) {  // 소문자 처리
                char shifted = (char) ((c - 'a' + n) % 26 + 'a');
                result.append(shifted);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("a B z", 1));  // "b C a"
    }
}
