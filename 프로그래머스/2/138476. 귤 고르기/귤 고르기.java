import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        Set<Integer> set = new HashSet<>(); // 크기 종류

        for (int i : tangerine) {
            set.add(i);
        }

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i : tangerine) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        // for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        //     System.out.println("entry = " + entry);
        // }

        List<Integer> order = new ArrayList<>(hm.values());
        Collections.sort(order, Collections.reverseOrder());

        int sum = 0;
        int count = 1;

        for (int i = 0; i < order.size(); i++) {
            int j = order.get(i);
            sum += j;
            if (sum >= k) {
                break;
            } else {
                count++;
            }
        }
        return count;

    }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int k = 6;
//         int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
//         sol.solution(k, tangerine);

//     }
}