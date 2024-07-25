import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {

        int[] numbers = IntStream.rangeClosed(1, number).toArray();
        
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : numbers) {
            int half = (int) Math.sqrt(i);
            map1.put(i, half);
        }


        ArrayList<Integer> list = new ArrayList<>();


        for (Integer i : map1.keySet()) {
            int count = 0;
            int j = map1.get(i);
            for (int k = 1; k <= j; k++) {
                if (i % k == 0) {
                    if (Math.pow(k, 2) == i) {
                        count++;
                    } else {
                        count += 2;
                    }
                }

            }
            list.add(count);
        }

        return list.stream().map(i -> i > limit ? power : i).mapToInt(i -> i).sum();
    }


}