import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();
        int order = 0;

        StringTokenizer st = new StringTokenizer(today, ".");
        Integer nowYear = Integer.parseInt(st.nextToken());
        Integer nowMonth = Integer.parseInt(st.nextToken());
        Integer nowDay = Integer.parseInt(st.nextToken());
        Integer nowDate = (28 * 12 * nowYear) + (28 * nowMonth) + (nowDay);

        Map<String, Integer> termMap = new HashMap<>();

        for (String s : terms) {
            
            String[] arr = s.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (String privacy : privacies) {
            order++;
            String[] array = privacy.split(" ");
            st = new StringTokenizer(array[0], ".");
            Integer fromYear = Integer.parseInt(st.nextToken());
            Integer fromMonth = Integer.parseInt(st.nextToken());
            Integer fromDay = Integer.parseInt(st.nextToken());

            String grade = array[1];

            Integer expiredDate = (fromYear * 28 * 12) + ((fromMonth + termMap.get(grade)) * 28) + fromDay - 1;

            if (nowDate > expiredDate) {
                answer.add(order);
            }
            
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}