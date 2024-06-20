import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for (int i : arr) if (i % divisor == 0) list.add(i);
        if (list.isEmpty()) list.add(-1);

        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();

    }
}