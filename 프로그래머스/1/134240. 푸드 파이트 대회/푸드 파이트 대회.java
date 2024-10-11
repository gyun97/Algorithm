/**
 * 1 : 1 푸파 대회
 * 선수 한 명은 왼쪽 -> 오른쪽, 다른 한 명은 오른쪽 -> 왼쪽이고 중간에는 물(0)이 있고 먼저 먹는 사람이 승자
 * 칼로리가 낮은 음식 순서대로 배치
 * 만약 한 종류의 음식 숫자가 홀수라면 -1 시켜서 두 명한테 균등하게 배분시켜야 한다.
 * food[0] = 물, food[i] = i 번째 음식
 */
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        
        int half = 1;
        for (int i = 1; i < food.length; i++) {

            if (food[i] == 1) continue;

            if (food[i] % 2 != 0) {
                food[i] -= 1;
            }
        
            half = food[i] / 2;

            for (int j = 0; j < half; j++) {
                sb.append(i);
            }
        }

        String copiedSb = sb.toString();
        StringBuilder reversedSb = sb.reverse();

        return copiedSb + "0" + reversedSb;
    }
}