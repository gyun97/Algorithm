import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        int[] widths = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            heights[i] = Integer.parseInt(st.nextToken());
            widths[i] = Integer.parseInt(st.nextToken());
        }

        int h = Arrays.stream(heights).max().getAsInt() - Arrays.stream(heights).min().getAsInt();
        int w = Arrays.stream(widths).max().getAsInt() - Arrays.stream(widths).min().getAsInt();
        int area = h * w;
        
        sb.append(area);
        System.out.println(area);
        }
    }