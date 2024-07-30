import java.util.Arrays;

class Solution {
    public int solution(String s) {

        String[] stringArray = s.split(""); //ba na na
//        System.out.println(Arrays.toString(stringArray));

        int result = 0;
        int index = 0;
        String x = stringArray[0];
        int xCount = 0;
        int yCount = 0;

        for (int i = 0; i < stringArray.length; i++) {

            if (x.equals(stringArray[i])) {
                xCount++;
            } else {
                yCount++;
            }

            if (xCount == yCount) {
                result++;
                if (i == stringArray.length - 1) {
                    break;
                } else {
                    x = stringArray[i + 1];
                }

            }
        }

        if (xCount != yCount) {
            result ++;
        }

        
        return result;
        }
    }

