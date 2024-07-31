import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        // 문자와 해당 문자가 위치한 키에서의 인덱스를 기록할 맵 생성
        Map<Character, Integer> charToMinPress = new HashMap<>();
        
        // 키 맵을 순회하면서 각 문자의 최소 누름 횟수 기록
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                // 문자 c가 이미 기록되어 있는 경우
                if (charToMinPress.containsKey(c)) {
                    // 현재 기록된 누름 횟수와 비교하여 최소값으로 업데이트
                    charToMinPress.put(c, Math.min(charToMinPress.get(c), j + 1));
                } else {
                    // 새로운 문자일 경우 기록
                    charToMinPress.put(c, j + 1);
                }
            }
        }

        // 각 타겟 문자열에 대해 최소 누름 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            boolean canBeTyped = true;

            for (char c : target.toCharArray()) {
                if (charToMinPress.containsKey(c)) {
                    totalPress += charToMinPress.get(c);
                } else {
                    // 해당 문자를 입력할 수 없는 경우
                    canBeTyped = false;
                    break;
                }
            }

            result[i] = canBeTyped ? totalPress : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] keymap = {"AB", "CD", "EFG"};
        String[] targets = {"AC", "AEF", "BEF"};
        int[] result = sol.solution(keymap, targets);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
