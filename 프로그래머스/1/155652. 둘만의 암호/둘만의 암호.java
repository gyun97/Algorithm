class Solution {

    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    j--; // skip에 포함된 문자는 건너뛰어야 하므로 j를 증가시키지 않는다.
                
                }
            }
            answer += c;
        }

        return answer;
    }
}
