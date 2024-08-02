import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> hamburger = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            hamburger.add(ingredient[i]);

            // 패턴이 최소 크기 이상일 때만 체크
            if (hamburger.size() >= 4) {
                // 패턴이 맞는지 확인
                if (hamburger.get(hamburger.size() - 4) == 1 &&
                    hamburger.get(hamburger.size() - 3) == 2 &&
                    hamburger.get(hamburger.size() - 2) == 3 &&
                    hamburger.get(hamburger.size() - 1) == 1) {

                    // 패턴이 맞다면 카운트 증가
                    answer++;

                    // 패턴에 해당하는 요소를 제거
                    for (int j = 0; j < 4; j++) {
                        hamburger.remove(hamburger.size() - 1);
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
