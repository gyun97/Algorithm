import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        List<String> wantList = new ArrayList<>();

        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                wantList.add(want[i]);
            }
        }

        int answer = 0;

        List<String> discountList = Arrays.stream(discount).collect(Collectors.toList());
        
        Collections.sort(wantList);
        
        for (int i = 0; i <= discount.length - 10; i++) {
            List<String> list = new ArrayList<>(discountList.subList(i, i + 10));
            Collections.sort(list);

            if (list.equals(wantList)) {
                answer++;
            }
        }

        return answer;
    }
}