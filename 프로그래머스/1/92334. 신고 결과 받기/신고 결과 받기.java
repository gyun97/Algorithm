import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, Integer> idSeq = new HashMap<>();
        Map<String, HashSet<String>> reportMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idSeq.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] stringArray = report[i].split(" ");
            reportMap.get(stringArray[1]).add(stringArray[0]);
        }

        for (String id : reportMap.keySet()) {
            if (reportMap.get(id).size() >= k) {
                HashSet<String> reporter = reportMap.get(id);
                for (String name : reporter) {
                    answer[idSeq.get(name)]++;
                }
            }
        }
        return answer;


    }
}