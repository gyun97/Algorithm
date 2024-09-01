class Solution {
    public int solution(String t, String p) {

        long longP = Long.parseLong(p);
        int result = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            long longT = Long.parseLong(t.substring(i, i + p.length()));
            System.out.println(longT);
            if (longT <= longP) {
                result++;

            }
        }
        return result;

    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        String t = "500220839878";
//        String p = "7";
//        System.out.println(sol.solution(t, p));
//    }
}