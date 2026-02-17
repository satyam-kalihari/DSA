package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class  Edge {
    
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

            graph[0].add(new Edge(0, 1, 2));
            graph[1].add(new Edge(1, 0, 2));

            graph[0].add(new Edge(0, 2, 4));
            graph[2].add(new Edge(2, 0, 4));

            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 1, 1));

            graph[1].add(new Edge(1, 3, 7));
            graph[3].add(new Edge(3, 1, 7));

            graph[2].add(new Edge(2, 4, 3));
            graph[4].add(new Edge(4, 2, 3));
            
            graph[3].add(new Edge(3, 4, 1));
            graph[4].add(new Edge(4, 3, 1));
    }

    static class Pair implements Comparable<Pair> {
    
        int n;
        int cost;
        public Pair(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void primsAlgo(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new  Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair cuPair = pq.remove();
            if (!vis[cuPair.n]) {
                vis[cuPair.n] = true;
                finalCost += cuPair.cost;

                for(int i = 0; i < graph[cuPair.n].size(); i++){
                    Edge e = graph[cuPair.n].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }

    
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        createGraph(graph);
        primsAlgo(graph);
    }
}
