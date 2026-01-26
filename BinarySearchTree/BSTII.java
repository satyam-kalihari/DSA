package BinarySearchTree;

public class BSTII {
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

    public static Node treeForSortedArray(int[] arr, int start, int end){

        if (start>end) {
            return null;
        }
        if (start==end) {
            Node root =  new Node(arr[start]);
            return root;
        }

        int mid = start+(end-start)/2;

        Node root = new Node(arr[mid]);
        root.left = treeForSortedArray(arr, start, mid-1);
        root.right = treeForSortedArray(arr, mid+1, end);
        

        return root;
    }

    public static int heightOfThree(Node root){

        if (root == null) {
            return 0;
        }

        return Math.max(heightOfThree(root.left), heightOfThree(root.right)) + 1;
    }

    public static void printInorderBST(Node root){
        if (root == null) {
            return;
        }
        printInorderBST(root.left);
        System.out.print(root.data + " ");
        printInorderBST(root.right);
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 8, 10, 11, 12, 15, 23, 27};
        Node root = treeForSortedArray(arr, 0, arr.length-1);

        System.out.println(heightOfThree(root));
        printInorderBST(root);
    }
}
