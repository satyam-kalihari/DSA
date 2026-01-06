package LinkedList;

public class Linkedlist {
    
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

    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add in last
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //add in middle
    public void add(int index, int data){
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
}
