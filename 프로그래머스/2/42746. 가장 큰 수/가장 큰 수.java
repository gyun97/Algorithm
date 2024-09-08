import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();

        String[] stringNums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(stringNums, (a, b) -> (b + a).compareTo(a + b));

        // 정렬된 문자열을 연결하여 결과를 만듦
        if (stringNums[0].equals("0")) {
            return "0";  // 만약 가장 큰 값이 "0"이면, 모든 값이 0이므로 "0"을 반환
        }

        Arrays.stream(stringNums)
                .forEach(sb::append);

        return sb.toString();
    }
}