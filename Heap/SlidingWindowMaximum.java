package Heap;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static class Info implements Comparable<Info> {
        int idx;
        int data;
        Info(int idx, int data){
            this.idx = idx;
            this.data = data;
        }

        @Override
        public int compareTo(Info i2){
            return i2.data - this.data;
        }
    }
    

    public static void main(String[] args) {
        int[] window = { 1, 3, -1, -3, 5, 3, 6, 7};
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int k = 3;
        int n = window.length;
        int[] ans = new int[n-k+1];

        for (int i = 0; i < k; i++) {
            pq.add(new Info(i, window[i]));
        }

        ans[0] = pq.peek().data;
        for (int i = 3; i < window.length; i++) {
            while (pq.peek().idx < i-k+1) {
                pq.remove();
            }
            pq.add(new Info(i, window[i]));
            ans[i-k+1] = pq.peek().data;
        }
        
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
