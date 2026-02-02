import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlays = new HashMap<>(); // 각 장르별 총 플레이 수
        Map<String, Map<Integer, Integer>> songs = new HashMap<>(); // 각 장르별 노래의 플레이 수와 고유 번호 
        
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            // songs.put(genres[i], new HashMap<>());
            
            songs.putIfAbsent(genres[i], new HashMap<>());
            
            songs.get(genres[i]).put(i, plays[i]);
        
        }
        
        // System.out.println(totalPlays);
        // System.out.println(songs);
        
        List<String> genreOrder = new ArrayList<>(totalPlays.keySet());
        Collections.sort(genreOrder, (a, b) -> totalPlays.get(b) - totalPlays.get(a));
        // System.out.println(genreOrder);
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : genreOrder) {
            Map<Integer, Integer> map = songs.get(genre);
            List<Integer> songOrder = new ArrayList<>(map.keySet());
            Collections.sort(songOrder, (a, b) -> map.get(b) - map.get(a));
            
            answer.add(songOrder.get(0));
            if (songOrder.size() > 1) answer.add(songOrder.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
        
        
    }
}