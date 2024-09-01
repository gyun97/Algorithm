class Solution {
    public String solution(String s) {

        int idx = 0;
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (idx % 2 == 0 && s.charAt(i) != ' ') {
                answer += Character.toUpperCase(s.charAt(i));
                idx++;
            } else if (idx % 2 != 0 && s.charAt(i) != ' ') {
                answer += Character.toLowerCase(s.charAt(i));
                idx++;
            } else {
                answer += s.charAt(i);
                idx = 0;
            }
        }
        return answer;

    }
}