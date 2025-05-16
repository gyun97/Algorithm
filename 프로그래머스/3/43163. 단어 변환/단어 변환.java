class Solution {
    
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String cur, String target, String[] words, int depth) {
        if (cur.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!visited[i] && canChange(cur, word)) {
                visited[i] = true;
                dfs(word, target, words, depth + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        
        return diff == 1;
        
    }
    
}