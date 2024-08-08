import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
//        String[] answer = {};
//        return answer;

        Map<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            int currentRanking = ranking.get(calling);
            int frontRanking = currentRanking - 1;
            String frontPlayer = players[currentRanking - 1];

            ranking.replace(calling, frontRanking);
            ranking.replace(frontPlayer, currentRanking);

            players[currentRanking] = frontPlayer;
            players[frontRanking] = calling;
        }

        return players;








    }
}