//import java.util.*;
//import java.util.stream.Collectors;
//
//class Solution {
//    public int solution(int[] topping) {
//
//        List<Integer> list = Arrays.stream(topping).boxed().collect(Collectors.toList());
//
//        int count = 0;
//
//        for (int i = 1; i <= topping.length; i++) {
//            Set<Integer> set2 = new HashSet<>(list.subList(0, i));
//            Set<Integer> set3 = new HashSet<>(list.subList(i, topping.length));
//            if (set2.size() == set3.size()) {
//                count++;
//            }
//        }
//        return count;
//
//    }
//
//}


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {

        int result = 0;

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        int[] leftArr = new int[topping.length];
        int[] rightArr = new int[topping.length];

        // topping 왼쪽부터 고유 토핑 수 카운트
        for (int i = 0; i < topping.length; i++) {
            leftSet.add(topping[i]);
            leftArr[i] = leftSet.size();
        }

        // topping 왼쪽부터 고유 토핑 수 카운트
        for (int i = rightArr.length - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightArr[i] = rightSet.size();
            
        }

         // 고유 토핑 수가 같은 경우 찾기
        for (int i = 0; i < topping.length - 1; i++) {
            if (leftArr[i] == rightArr[i + 1]) {
                result++;
            }

        }
        return result;

    }
}