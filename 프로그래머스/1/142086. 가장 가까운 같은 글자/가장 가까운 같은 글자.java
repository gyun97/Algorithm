import java.util.HashMap;
import java.util.Map;

/**
 * 0. 문자열 s의 각 자리를 하나씩 순회하면서 자신 이전에 같은 글자가 있었는지, 있었다면 가장 가까운 글자가 자신의 몇 번째 앞에 있는지 result 배열에 표시해야 한다.
 * 1. 해시맵 {글자 : 위치}를 확인하자.
 */
class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!hm.containsKey(c)) {
                result[i] = -1;
                hm.put(c, i);
            } else {
                result[i] = i - hm.get(c);
                hm.replace(c, i);
            }
        }

        return result;
    }
}