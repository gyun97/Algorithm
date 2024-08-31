class Solution {
    static int count = -1;
    static String[] alphabets = {"A", "E", "I", "O", "U"};
    static boolean flag = false;

    public int solution(String word) {

        String myWord = "";
        dfs(word, myWord);
        System.out.println(count);
        return count;

    }

    private void dfs(String word, String myWord) {

        if (!flag) {
            count++;
        }

        if (myWord.equals(word)) {
            flag = true;
            return;
        }

        if (myWord.length() == 5 || flag) {
            return;
        }

        for (String alphabet : alphabets) {
            dfs(word, myWord + alphabet);
        }

//        dfs(word, myWord + "A");
//        dfs(word, myWord + "E");
//        dfs(word, myWord + "I");
//        dfs(word, myWord + "O");
//        dfs(word, myWord + "U");

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word = "AAAAE";
        sol.solution(word);
    }
}  