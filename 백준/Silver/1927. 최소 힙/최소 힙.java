import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        while (N-- > 0) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (!heap.isEmpty()) {
                    sb.append(heap.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else {
                heap.add(order);
            }


        }
        System.out.println(sb);
        
    }
    
}