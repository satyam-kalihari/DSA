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


    //Find the middle
    public Node findMiddleNode(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow  = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPalindrome(){
        if (head == null || head.next == null) {
            return true;
        }

        //Find middle
        Node midNode = findMiddleNode(head);
        
        //reverse the right side of the node
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //check both the side
        Node riNode = prev;
        Node lNode = head;
        while (riNode != null) {
            if (lNode.data != riNode.data) {
                return false;
            }
            riNode = riNode.next;
            lNode = lNode.next;
        }

        return true;
    }

    public void printLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Detect Loop
    public static boolean isLoop(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //removing loop
    public static void removeLoop(){

        //check if there is a loop
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return;
        }

        //find the meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        //break the loop
        prev.next = null;
    }

    //fetMid
    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //merge node
    private Node mergeNode(Node leftHead, Node rightHead){
        Node mergeNode = new Node(-1);
        Node temp = mergeNode;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data < rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergeNode.next;
    }

    //Merge sort
    public Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }

        //find mid
        Node midNode = getMid(head);

        //divided
        Node rightHead = midNode.next;
        midNode.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return mergeNode(newLeft, newRight);
    }
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addLast(5);
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(6);
        ll.addLast(4);
        ll.addLast(2);
        // Node tempNode = head;
        // tempNode.next.next.next.next = tempNode.next;

        // ll.printLinkedList();
        // if (ll.checkPalindrome()) {
        //     System.out.println("It is palindrome");
        // }else{
        //     System.out.println("Not a palindrome");
        // }
        // System.out.println(isLoop());
        // removeLoop();
        // System.out.println(isLoop());
        ll.printLinkedList();
        head = ll.mergeSort(head);
        ll.printLinkedList();
    }


}
