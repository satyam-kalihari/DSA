package Heap;

import java.util.PriorityQueue;

public class NearByCar {
    
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        int idx;

        Point(int x, int y, int dist, int idx){
            this.dist = dist;
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point po2) {
            return this.dist - po2.dist;
        }
    }

    public static void main(String[] args) {
        int[][] path = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < path.length; i++) {
            int x = path[i][0];
            int y = path[i][1];
            int dist = x*x+y*y;
            pq.add(new Point(x, y, dist, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("c" + pq.remove().idx);
        }
    }

}
