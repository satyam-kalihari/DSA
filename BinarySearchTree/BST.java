package BinarySearchTree;

public class BST {
    
    public static class Node {  
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int val){
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = buildBST(root.left, val);
        }else{
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void printInorderBST(Node root){
        if (root == null) {
            return;
        }
        printInorderBST(root.left);
        System.out.println(root.data);
        printInorderBST(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 2, 9, 3, 4, 10, 6, 1, 7};
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = buildBST(root, arr[i]);
        }

        printInorderBST(root);
    }
}
