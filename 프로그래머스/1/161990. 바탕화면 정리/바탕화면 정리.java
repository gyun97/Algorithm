/**
 * (가장 작은 y, x) ~ (가장 큰 y, x)
 *
 */


class Solution {
    public int[] solution(String[] wallpaper) {

        int topY = Integer.MAX_VALUE;
        int topX = Integer.MAX_VALUE;
        int bottomY = Integer.MIN_VALUE;
        int bottomX = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    topY = Math.min(topY, i);
                    topX = Math.min(topX, j);
                    bottomY = Math.max(bottomY, i + 1);
                    bottomX = Math.max(bottomX, j + 1);
                }


            }
        }
        return new int[]{topY, topX, bottomY, bottomX};
    }

}