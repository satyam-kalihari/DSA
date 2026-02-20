package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    
    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }

        
    }

    static void createGraph(ArrayList<Edge> edges) {
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void init(){
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int a){
        if (a == par[a]) {
            return a;
        }

        return par[a] = find(par[a]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if (rank[parB] > rank[parA]) {
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
        }
    }

    public static void kruskalsMst(ArrayList<Edge> edges, int v){
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < v-1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    static int n = 4; //vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMst(edges, n);
    }
}
