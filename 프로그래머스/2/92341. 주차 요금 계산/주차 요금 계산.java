import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {

        Map<String, LocalTime> hm = new HashMap<>();
        Map<String, Long> sum = new HashMap<>();


        for (int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
                LocalTime time = LocalTime.of(Integer.parseInt(s[0].substring(0, 2)), Integer.parseInt(s[0].substring(3)));
            if (!hm.containsKey(s[1])) {
                hm.put(s[1], time);
            } else {
                Duration duration = Duration.between(hm.get(s[1]), time);
                sum.put(s[1], sum.getOrDefault(s[1], 0L) + duration.toMinutes());
                hm.remove(s[1]);
            }
        }

        for (String carNum : hm.keySet()) {
            LocalTime time = LocalTime.of(23, 59);
            Duration duration = Duration.between(hm.get(carNum), time);
            sum.put(carNum, sum.getOrDefault(carNum, 0L) + duration.toMinutes());
        }

        List<String> sort = new ArrayList<>(sum.keySet());
        Collections.sort(sort);
        
        List<Integer> result = new ArrayList<>();

        for (String carNum : sort) {
            if (sum.get(carNum) <= fees[0]) {
                result.add(fees[1]);
            } else {
                int fee = fees[1] + (int) Math.ceil((double)(sum.get(carNum) - fees[0]) / fees[2]) * fees[3];
                result.add(fee);

            }
        }
        return result;


    }
}