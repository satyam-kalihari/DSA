package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave {

    public static void interleaveTwoHalves(Queue<Integer> q){

        int halfSize = q.size()/2;
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < halfSize; i++) {
            q2.add(q.remove());
        }

        while (!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleaveTwoHalves(q);
        System.out.println(q);

    }
}
