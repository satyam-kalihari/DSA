package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LectureI {
    public static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        //vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //vertex 2
        graph[2].add(new Edge(2, 1, 0));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //vertex 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        //vertex 0
        graph[4].add(new Edge(4, 2, 2));

        //neighbours of 2
        // for (Edge nei : graph[2]) {
        //     System.out.println(nei.dest);
        // }
        bfs(graph);
    }
}
