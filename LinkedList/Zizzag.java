package LinkedList;

public class Zizzag {
    public class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //Find the middle
    public Node findMiddleNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow  = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void printLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Zig Zag
    public void zigZag(){

        //find mid
        Node midNode = findMiddleNode(head);

        //reverce it
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        midNode.next = null;
        Node leftHeaNode = head;
        Node rightHeaNode = prev;
        Node nextLeft = null;
        Node nextRight = null;
        //join left head to right head
        while (leftHeaNode != null && rightHeaNode != null) {
            nextLeft = leftHeaNode.next;
            leftHeaNode.next = rightHeaNode;
            nextRight = rightHeaNode.next;
            rightHeaNode.next = nextLeft;

            leftHeaNode = nextLeft;
            rightHeaNode = nextRight;
        }
    }

    public static void main(String[] args) {
        Zizzag ll = new Zizzag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printLinkedList();
        ll.zigZag();
        ll.printLinkedList();
    }
}
