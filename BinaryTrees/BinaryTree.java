package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

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

    static class BinaryTreeBuild{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.lNode = buildTree(nodes);
            newNode.rNode = buildTree(nodes);

            return newNode;
        }
    }

    public static void printTree(Node rootNode){

        System.out.print(rootNode.data + ", ");
        if (rootNode.lNode != null) {
            printTree(rootNode.lNode); 
        }
        else System.out.print(-1 + ", ");
        if (rootNode.rNode != null) {
            printTree(rootNode.rNode); 
        }
        else System.out.print(-1 + ", ");
    }

    public static void levelOrder(Node rootNode){

        if (rootNode == null) {
            return;
        }

        Queue<Node> nodeList = new LinkedList<>();
        nodeList.add(rootNode);
        nodeList.add(null);

        while (!nodeList.isEmpty()) {
            Node curr = nodeList.remove();

            if (curr == null) {
                System.out.println();
                if (nodeList.isEmpty()) {
                    break;
                }
                else{
                    nodeList.add(null);
                }
            }
            else{
                System.out.print(curr.data + " ");
                if (curr.lNode != null) {
                    nodeList.add(curr.lNode);
                }
                if (curr.rNode != null) {
                    nodeList.add(curr.rNode);
                }
            }    
        }
    }
    
    public static int heightOfATree(Node root){
        if (root == null) {
            return 0;
        }

        int lHeight = heightOfATree(root.lNode);
        int rHeight = heightOfATree(root.rNode);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // BinaryTreeBuild tree = new BinaryTreeBuild();
        Node root = BinaryTreeBuild.buildTree(preorder);
        printTree(root);
        System.out.println();
        levelOrder(root);
        int treeHeight = heightOfATree(root);
        System.out.println(treeHeight);
    
    }
}
