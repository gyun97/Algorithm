import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        /** int[] win_nums에는 로또 당첨 번호 6개가 들어있고
         *  int[] lottos에는 자신의 로또 번호 6개가 들어있는데 훼손되어서 알아볼 수 없는 숫자는 0으로 표기되었다.
         *  가능한 최고 순위와 최저 순위 계산 도출
         *  만약 값이 0이면 최고 순위 계산 때에는 맞은 숫자로 처리하고, 최저 순위 계산 때에는 틀린 숫자로 처리하자.
         *         int[] lottos = {4, 1, 0, 0, 31, 25};
         *         int[] win_nums = {31, 10, 45, 1, 6, 19};
         */

        int[] result = new int[2];

        List<Integer> lottosList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());


        // 1. 먼저 최저 순위를 따져보자.
        int count1 = 0;

        for (Integer i : lottosList) {
            if (winNumsList.contains(i)) {
                count1++;
            }
        }
//        System.out.println(count1);


        switch (count1) {
            case 0:
                result[1] = 6;
                break;
            case 1:
                result[1] = 6;
                break;
            case 2:
                result[1] = 5;
                break;
            case 3:
                result[1] = 4;
                break;
            case 4:
                result[1] = 3;
                break;
            case 5:
                result[1] = 2;
                break;
            case 6:
                result[1] = 1;
                break;
        }
//        System.out.println(result[1]);


//        int[] lottos = {4, 1, 0, 0, 31, 25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int count2 = 0;
        // 2. 최고 순위를 따져보자.
        for (Integer i : lottosList) {
            if (winNumsList.contains(i)) {
                count2++;
            }
        }

        int zeroCount = 0;
        for (Integer i : lottosList) {
            if (i == 0) zeroCount++;
        }
        count2 += zeroCount;

//        System.out.println(count2);

        switch (count2) {
            case 0:
                result[0] = 6;
                break;
            case 1:
                result[0] = 6;
                break;
            case 2:
                result[0] = 5;
                break;
            case 3:
                result[0] = 4;
                break;
            case 4:
                result[0] = 3;
                break;
            case 5:
                result[0] = 2;
                break;
            case 6:
                result[0] = 1;
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//
//        int[] lottos = {4, 1, 0, 0, 31, 25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};
//
//        System.out.println(sol.solution(lottos, win_nums));
//
//    }

}