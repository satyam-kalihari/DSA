package Heap;

import java.util.PriorityQueue;

public class CountNRopes {
    
    public static void main(String[] args) {
        int[] rope = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        for (int i = 0; i < rope.length; i++) {
            pq.add(rope[i]);
        }

        while (pq.size() > 1) {
            int curr = pq.remove()+pq.remove();
            cost += curr;
            pq.add(curr);
        }

        System.out.println("Cost: " + cost);
    }
}
