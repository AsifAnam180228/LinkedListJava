package com.asifanam;

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2: new node's next should point to head
        newNode.next = head;
        //step 3: head should point to new node
        head = newNode;

    }
    public void addLast(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //tail's next should point to new node
        tail.next = newNode;
        //new node's tail = null
       tail= newNode;
    }

    public  void addInMiddle(int index, int data){
        //create new node

        Node newNode = new Node(data);
        if(index == 0){
            addFirst(data);
            return;
        }
        size++;
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        //set new node's next to temp's next
        newNode.next = temp.next;
        //set temp's next to new node
        temp.next = newNode;

    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int value = head.data;
            head = tail = null;
            size=0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int value = head.data;
            head = tail = null;
            size=0;
            return value;
        }
        //prev : i = size-2
        Node temp = head;
        for (int i = 0; i < size-2; i++){
            temp = temp.next;
        }
        int value = temp.next.data;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }
    public void printLinkedList(){

        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int searchHelper(Node head, int key){
        if(head == null){
            return  -1;
        }
        if(head.data ==key){
            return 0;
        }
        int index = searchHelper(head.next, key);
        if(index == -1){
            return -1;
        }
        return index+1;
    }
    public int recursiveSearch(int key){
        return searchHelper(head, key);
    }

    public void reverseLinkedList(){
        Node prev = tail = null;
        Node current = head;
        Node next;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void removeNthFromEnd(int n){
        int sz = 0;
        Node temp = head;
        while (temp!= null){
            sz++;
            temp = temp.next;
        }
        if(n > sz){
            System.out.println("Invalid index");
            return;
        }
        //remove first
        if(n == sz){
            head = head.next;
            return;
        }

        //find sz-n
        Node prev = head;
        int indx = sz-n;
        for (int i = 1; i < indx; i++){
            prev = prev.next;
        }
        //skip the middle node
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next!= null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if (head == null || head.next == null){
            return true;
        }

        // find mid
        Node midNode = findMid(head);
        // reverse second half
        Node prev = null;
        Node current = midNode;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // compare first half and second half
        Node right = prev;
        Node left = head;
        while (right !=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //Floyed's cycle
    public static boolean checkCycleInLinkedList(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next !=null ){
            slow = slow.next; //increment by 1
            fast = fast.next.next; //increment by 2

            if(slow == fast){
                return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(2);

//        linkedList.addLast(3);
//        linkedList.addLast(4);
//        linkedList.addLast(4);
//        linkedList.addLast(3);
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println("Is there a cycle: "+checkCycleInLinkedList());

//        linkedList.addInMiddle(2, 50);
//        linkedList.printLinkedList();
//        System.out.println("Size of linked list: "+ size);
//        System.out.println("Is Palindrome: "+ linkedList.checkPalindrome());
//        System.out.println();
//        System.out.println("Element found at index: "+ linkedList.recursiveSearch(50));
//        linkedList.reverseLinkedList();
//        System.out.println("Reversed linked list: ");
//        linkedList.printLinkedList();
//        System.out.println();
//        linkedList.removeNthFromEnd(3);
//        linkedList.printLinkedList();

//        linkedList.removeFirst();
//        linkedList.printLinkedList();

//        System.out.println("Size of linked list: "+ size);
//        linkedList.removeLast();
//        linkedList.printLinkedList();
//
//        System.out.println("Size of linked list: "+ size);
    }
}
