public class Solution {
    public int solution(int n) {

        String s = String.valueOf(n);
        String[] strings = s.split("");
        int sum = 0;
        for (String string : strings) {
            sum += Integer.parseInt(string);
        }
        return sum;


    }
}