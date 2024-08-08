import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
//        return answer;

        Map<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            int currentRanking = ranking.get(calling);
            String frontPlayer = players[currentRanking - 1];

            ranking.replace(frontPlayer, currentRanking);
            players[currentRanking] = frontPlayer;

            ranking.replace(calling, currentRanking - 1);
            players[currentRanking - 1] = calling;

            
        }
        return players;





    }
}