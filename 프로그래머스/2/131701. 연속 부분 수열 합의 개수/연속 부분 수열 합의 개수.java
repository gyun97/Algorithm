import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set<Integer> answer = new HashSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i<2; i++) {
            for (int element : elements) {
                list.add(element);
            }
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                List<Integer> subList = list.subList(i, i + j);
                int sum = 0;
                for (Integer integer : subList) {
                    sum += integer;
                }
                answer.add(sum);
            }
        }

        return answer.size();


    }
}