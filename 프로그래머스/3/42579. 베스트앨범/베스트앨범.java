import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlays = new HashMap<>(); // 장르별 노래 재생 횟수를 기록할 해시맵
        Map<String, Map<Integer, Integer>> songsByGenre = new HashMap<>(); // 각 장르별 노래 고유 번호: 재생 수 기록할 해시맵 ex) [classic : [0:500, 2:150], pop : [1:600]]
        
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]); // 각 장르별 재생 횟수 추가
            
            songsByGenre.putIfAbsent(genres[i], new HashMap<>()); // 만약 해당 장르가 아직 없다면 추가
            
            songsByGenre.get(genres[i]).put(i, plays[i]); 
        }
        
        // System.out.println(totalPlays);
        // System.out.println(songsByGenre);
        
        List<String> genreOrder = new ArrayList<>(totalPlays.keySet()); // 장르별 재생순 정렬 리스트
        Collections.sort(genreOrder, (a, b) -> totalPlays.get(b) - totalPlays.get(a)); // 장르 재생순 리스트 내림차순 정렬
         
        // System.out.println(genreOrder);
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : genreOrder) {
            Map<Integer, Integer> map = songsByGenre.get(genre); // 각 [장르 :노래 번호 : 재생 수] 해시맵 가져오기
            List<Integer> songOrder = new ArrayList<>(map.keySet()); // 각 장르의 노래 순서 담을 리스트(노래 번호)
            Collections.sort(songOrder, (a, b) -> map.get(b) - map.get(a)); // 재생순 내림차순 정렬
            
            answer.add(songOrder.get(0));
            if (songOrder.size() > 1) answer.add(songOrder.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    
        
    }
}