import java.util.*;

class Node {
    String word;
    int depth;
    
    public Node(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
    
}

class Solution {
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        int answer = bfs(begin, target, words, 0);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words, int depth) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            String curWord = node.word;
            int curDepth = node.depth;
            
            if (curWord.equals(target)) return curDepth;
            
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                
                if (!visited[i] && canChange(curWord, word)) {
                    visited[i] = true;
                    q.offer(new Node(word, curDepth + 1));
                }
                
            }
        }
        return 0;
        
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
} 