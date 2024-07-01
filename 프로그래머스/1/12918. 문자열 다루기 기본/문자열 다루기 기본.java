import java.util.Arrays;

class Solution {
    public boolean solution(String s) {

        char[] charList = s.toCharArray();

        if (charList.length != 4 && charList.length != 6) return false;

        for (char c : charList) {
            if (!Character.isDigit(c)) return false;
        }
        return true;



    }
}