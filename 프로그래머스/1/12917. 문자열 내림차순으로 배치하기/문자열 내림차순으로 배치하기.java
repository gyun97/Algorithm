    import java.util.Arrays;
    import java.util.Collections;

    class Solution {
        public String solution(String s) {

//            String answer = "";

            String[] stringArray = s.split("");

            Arrays.sort(stringArray, Collections.reverseOrder());
            System.out.println(Arrays.toString(stringArray));

            String answer = String.join("", stringArray);

//            for (String string : stringArray) {
//                answer += string;
//            }

            return answer;

        }
    }