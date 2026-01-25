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
        System.out.print(root.data + " ");
        printInorderBST(root.right);
    }

    public static Node delete(Node root, int val){
        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else{
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            Node IS = findInorderSuc(root);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuc(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 2, 9, 3, 4, 10, 6, 1, 7};
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = buildBST(root, arr[i]);
        }

        printInorderBST(root);
        delete(root, 10);
        printInorderBST(root);

    }
}
