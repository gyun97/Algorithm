import java.util.Set;
import java.util.TreeSet;

/**
 * 브루트 포스 문제이다.
 * 1. 배열에서 수를 두 개씩 뽑아서 더할 수 있는 모든 수를 구한다.
 * 2. 해당 수들을 담은 배열을 오름차순 정렬하여 리턴한다.
 */
class Solution {
    public Integer[] solution(int[] numbers) {

        Set<Integer> resultSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                resultSet.add(numbers[i] + numbers[j]);
            }
        }
        return resultSet.toArray(new Integer[0]);


    }
}