package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {

    static class Node {
        
        int data;
        Node lNode;
        Node rNode;

        public Node(int data){
            this.data = data;
            this.lNode = null;
            this.rNode = null;
        }
        
    }
    
    public static class Info {
    
        Node node;
        int hd;

        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node rootNode){

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> list = new HashMap<>();

        q.add(new Info(rootNode, 0));
        q.add(null);

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {

            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            }
            else{
                if (!list.containsKey(curr.hd)) {
                    list.put(curr.hd, curr.node);
                }
                if (curr.node.lNode != null) {
                    q.add(new Info(curr.node.lNode, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.rNode != null) {
                    q.add(new Info(curr.node.rNode, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(list.get(i).data + " ");
        }
    }

    public static void main(String[] args) {

        Node subTree = new Node(2);
        subTree.lNode = new Node(4);
        subTree.rNode = new Node(5);
        subTree.lNode.lNode = new Node(6);

        topView(subTree);
    }
}
