class Node{
    Node next;
    int data;
    Node(int x){
        data=x;
        next=null;
    }
}
public class LinkedListImplementation {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(50);
        head.next.next.next = new Node(50);
        head.next.next.next.next = new Node(68);
        head.next.next.next.next.next=new Node(68);

         searchElement(head, 9);
        insertAtEnd(head, 9);
        deleteFirst(head);
       deleteLast(head);
        deleteLast(head);
       sortedInsert(head,45);
        sortedInsert(head,5);
        middleElement(head);
        printList(head);
        NodeFromTheEnd(head,3);
       removeDuplicates(head);
       printList(head);


    }

    //Traversing in Linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    //searching an element in a Linkedist
    public static void searchElement(Node head, int element) {
        int position = 1;
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                System.out.println(position);
            } else {
                position++;
                current = current.next;
            }
        }
        System.out.println("Element is not present");
    }

    //insert at the begning of the linked list
    public static Node insertAtBegining(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return head;
    }

    // insert at the end of the linked list
    public static void insertAtEnd(Node head, int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
            return;
        }
        Node c = head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = temp;
    }

    //deleting the first node of the linked list
    public static Node deleteFirst(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        head = head.next;
        current.next = null;
        return current;
    }

    //deleting the last node of the linked list
    public static Node deleteLast(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
    //insert at the given position
    public static Node sortedInsert(Node head,int value){
        Node n=new Node(value);
        if(head==null){
            return n;
        }
        if(head.data>value){
            n.next=head;
            return n;
        }
        Node current =head;
        while(current.next!=null && current.next.data<value){
            current=current.next;
        }
        n.next=current.next;
        current.next=n;
        return head;
    }
    //middle of the linked list
    public static void middleElement(Node head){
        if(head==null){
            return;
        }
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }
    // print the nth node from the end of the linked list
    public static void NodeFromTheEnd(Node head,int n){
        int length=0;
        for(Node current=head;current!=null;current=current.next){
            length++;
        }
        if(length<n){
            return;
        }
        Node current=head;

        for(int i=0;i<length-n+1;i++){
            current=current.next;
        }
        System.out.println(current.data);
    }
    //remove the dupicates in the list
    public static void removeDuplicates(Node head){
        Node current=head;
        while (current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }
            else{
              current=  current.next;
            }
        }
    }

}