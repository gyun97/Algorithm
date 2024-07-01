import java.util.*;

class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("\\d{4}|\\d{6}");
        return false;
    }
}
