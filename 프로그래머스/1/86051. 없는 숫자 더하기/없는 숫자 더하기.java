import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += i;
        }

        List<Integer> list = Arrays.stream(IntStream.range(0, 10).toArray()).boxed().collect(Collectors.toList());

        for (int number : numbers) {
            if (list.contains(number)) {
                answer -= number;
            }
        }

        return answer;
    }
}