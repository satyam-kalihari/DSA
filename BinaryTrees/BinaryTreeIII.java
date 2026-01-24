package BinaryTrees;

import java.util.ArrayList;

public class BinaryTreeIII {
    
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

    public static boolean getPath(Node root, int node, ArrayList<Node> path){

        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == node) {
            return true;
        }

        boolean ansLeft = getPath(root.lNode, node, path);
        boolean ansRight = getPath(root.rNode, node, path);

        if (ansLeft || ansRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static void lowestCommonAncestor(Node root, int node1, int node2){

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, node1, path1);
        getPath(root, node2, path2);

        int i = 0;
        for (; i < path1.size() && i<path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        System.out.println(path1.get(i-1).data);

    }

    public static Node lca2(Node root, int n1, int n2){

        if (root == null) {
            return null;
        }
        
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.lNode, n1, n2);
        Node rightLca = lca2(root.rNode, n1, n2);

        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDis(Node root, int n){
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDis = lcaDis(root.lNode, n);
        int rightDis = lcaDis(root.rNode, n);
        if (leftDis == -1 && rightDis == -1) {
            return -1;
        }

        else if (leftDis == -1) {
            return rightDis+1;
        }
        else {
            return leftDis+1;
        }


    }

    public static void minDistance(Node root, int n1, int n2){

        Node lca = lca2(root, n1, n2);
        int leftDis = lcaDis(lca, n1);
        int rightDis = lcaDis(lca, n2);

        System.out.println(leftDis+rightDis);
    }

    public static int kThAncestor(Node root, int n, int k){
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftAns = kThAncestor(root.lNode, n, k);
        int rightAns = kThAncestor(root.rNode, n, k);

        if (leftAns == -1 && rightAns == -1) {
            return -1;
        }
        int max = Math.max(leftAns, rightAns);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;

    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = BinaryTreeBuild.buildTree(preorder);

        // lowestCommonAncestor(root, 4, 5);
        // System.out.println(lca2(root, 4, 5).data);

        // minDistance(root, 4, 5);

        kThAncestor(root, 6, 2);
    }
}
