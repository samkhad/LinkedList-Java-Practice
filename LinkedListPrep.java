import java.util.HashSet;

public class LinkedListPrep{
    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertAtStart(Node head, int d){
        Node newNode = new Node(d);
        if (head == null){
            return newNode;
        }
        else{
            newNode.next = head;
            head= newNode;
            return head;
        }
    }

    public static Node insertAtEnd(Node head, int d){
        Node newNode = new Node(d);
        if (head == null){
            return newNode;
        }
        else{
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
            return head;
        }
    }


    public static Node insertAtIndex(Node head, int d, int index){

        if(index == 0){
            return insertAtStart(head, d);
        }
        else{
            Node newNode = new Node(d);
            Node curr = head;
            for(int i = 0; i <index -1; i++){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return head;
        }
    }

    public static void delete(Node head, int index){
        if (head == null){
            return;
        }
        else{
            Node curr = head;
            Node n1 = null;
            for(int i = 0;i < index -1; i ++){
                curr = curr.next;
            }
            n1 = curr.next;
            curr.next = n1.next;
            System.out.println(n1.data + " is deleted");
            n1 = null;
        }
    }


    public static void show(Node head){
        if(head == null){
            return;
        }
        else{
            Node curr = head;
            while (curr.next != null){
                System.out.print(curr.data+ " ->");
                curr =curr.next;
            }
            System.out.print(curr.data);
            System.out.println("\n--------------");
        }
    }

    public static int countNodes(Node head){
        Node curr =head;
        int count= 1;
        if (head == null){
            return -1;
        }
        else{
            while (curr.next != null){
                count++;
                curr =curr.next;
            }
        }
        return count;
    }

    public static Node reverseLinkedList(Node head){
        Node curr =head;
        Node prev = null;


        while (curr != null){
         Node  next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node reverseLinkedListIteratively(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node reversed  = reverseLinkedListIteratively(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public static boolean find(Node head, int k){
        if (head == null){
            return false;
        }
        Node curr = head;
        while (curr != null){
            if(curr.data == k){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static Node findMiddleNode(Node head){
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node deleteMiddleNode(Node head){
        if (head == null || head.next == null ) return null;
        Node slow = head;
        Node fast = head;
        Node n1 = null;

        while (fast != null && fast.next != null){
            n1 = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        n1.next = slow.next;
        return head;
    }
    public static Node kthFromLast(Node head, int pos){
        if (head == null) return null;
        if (pos <= 0) return null;

        Node p1 = head;
        Node p2 = head;
        for(int i=0;i<pos; i++){
            if(p1==null) return null;
            p1= p1.next;
        }

        while (p1!= null){
            p1 = p1.next;
            p2=p2.next;
        }
        return p2;
    }
    public static Node dedup(Node head){
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.next != null){
            if (curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr =curr.next;
            }
        }
        return head;
    }

    public static boolean hasLoop(Node head){
        if (head == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow= slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static Node insertNode(Node head, int d) {
        Node newNode = new Node(d);
        if (head == null) {
            return null;
        }
        if (d <= head.data) {
            newNode.next = head;
            head =newNode;
            return head;
        } else {
            Node curr = head;
            Node temp = null;
            while (curr != null && curr.data < newNode.data) {
                temp = curr;
                curr = curr.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            return head;
        }
    }


    public static Node add2No(Node n1, Node n2){
        Node dummy = new Node(0);
        Node n = dummy;
        int carry = 0;
        while (n1 != null || n2 != null){

            int sum = carry;
            if (n1 != null) sum += n1.data;
            if (n2 != null) sum += n2.data;

            n.next =new Node(sum % 10);
            n = n.next;
            carry = sum /10;

            if (n1 != null) n1 = n1.next;
            if(n2 != null) n2 = n2.next;
        }

        if (carry > 0 ){
            n.next = new Node (carry);
        }
        return dummy.next;
    }

    public static Node oddEvenIndexMerge(Node head){
        if (head == null)
        {
            return null;
        }
        Node oddHead = head;
        Node evenHead = head.next;
        Node even = evenHead;
        while(evenHead != null && evenHead.next != null){
            oddHead.next = evenHead.next;
            oddHead =oddHead.next;
            evenHead.next = oddHead.next;

            evenHead = evenHead.next;

        }
        oddHead.next = even;
        return head;
    }

    public static Node dedupUnSorted(Node head){
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        while(head != null){
            if(set.contains(head.data)){
                prev.next = head.next;
            }
            else{
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
        return head;
    }



    public static Node partitionAroundX(Node head, int x)
    {
        Node left = new Node (0);
        Node right = new Node(0);
        Node leftCurrent = left;
        Node rightCurrent =right;
        Node curr =head;
        while (curr != null){
            if (curr.data < x){
                leftCurrent.next = new Node (curr.data);
                leftCurrent = leftCurrent.next;
            }
            else{
                rightCurrent.next = new Node(curr.data);
                rightCurrent = rightCurrent.next;
            }
            curr = curr.next;
        }
        leftCurrent.next = right.next;
        return left.next;
    }

    public static Node intersectionOf2LL(Node A, Node B){
        if (A == null || B == null) return null;
        Node a = A;
        Node b = B;
        while (a != b){
            a = a == null ? B : a.next;
            b = b == null ? A : b.next;
        }
        return a;
    }

    public static boolean isPalindrome(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        while (slow != null){
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        slow = prev;
        while(slow!= null){
            if(head.data != slow.data){
                return false;
            }
            head= head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args){
        Node head = new Node (5);
        Node sec = new Node (15);
        Node third = new Node (15);
        head.next = sec;
        sec.next = third;
        LinkedListPrep ll = new LinkedListPrep();
        ll.show(head);

        Node n1= ll.insertAtStart(head, 1);
        ll.show(n1);
        Node n2 = ll.insertAtEnd(n1, 100);
        ll.show(n2);

        Node n3 = ll.insertAtIndex(n2, 10, 2);
        ll.show(n3);
        Node n4 = ll.insertAtIndex(n3, 25, 5);
        System.out.println("showing n4");
        ll.show(n4);

        Node deduped = ll.dedupUnSorted(n4);
        System.out.println("deduped");
        ll.show(deduped);

        Node oddEvenMerge = ll.oddEvenIndexMerge(n4);
        ll.show(oddEvenMerge);

        Node n41 = ll.insertNode(n4, 1);
        System.out.println("showing n41");
        ll.show(n41);



//        ll.delete(n4, 3);
//        ll.show(n4);
//        ll.delete(n4, 2);
//        ll.show(n4);

        int ct = ll.countNodes(n4);
        System.out.println(ct);

        Node rev = ll.reverseLinkedList(n4);
        ll.show(rev);

        if(ll.find(rev, 200)){
            System.out.println("found");
        }else{
            System.out.println(200 + " = not found");
        }

Node mid = ll.findMiddleNode(rev);
        System.out.println(mid.data);


        Node afterMiddleNode = ll.deleteMiddleNode(rev);
        ll.show(afterMiddleNode);

        Node kthElement = ll.kthFromLast(afterMiddleNode , 2);
        System.out.println(kthElement.data);

        Node dedup = ll.dedup(afterMiddleNode);
        System.out.println("deduped");
        ll.show( dedup);


        Node head1 = new Node(1);
        Node n21 = new Node (2);
        Node n22 = new Node (3);
        Node n23 = new Node(4);
        Node n24 = new Node(5);
        Node n25 =new Node (6);
      //
        head1.next = n21;
        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
       n25.next = n23;


        if (ll.hasLoop(head1)){
            System.out.println("Yes Loop");
        }
        else{
            System.out.println("No loop");
        }

        Node head2 = new Node(1);
        Node h1 = new Node (2);
        Node h2 = new Node (3);
        head2.next = h1;
        h1.next = h2;
        System.out.println("showing head2");
        ll.show(head2);

        Node head3 = new Node(7);
        Node j1 = new Node (8);
        Node j2 = new Node(3);
        head3.next = j1;
        j1.next= j2;
        System.out.println("showing head3");
        ll.show(head3);

        Node addedVal = ll.add2No(head2, head3);
        ll.show(addedVal);

Node head10 = new Node (15);
Node head11 = new Node (14);
Node head12 = new Node(2);
Node head13 = new Node(5);
Node head14 = new Node(10);
Node head15= new Node (11);
head10.next = head11;
head11.next=head12;
head12.next=head13;
head13.next=head14;
head14.next=head15;
System.out.println("showing head10");
ll.show(head10);
Node partitioned = ll.partitionAroundX(head10, 11);
ll.show(partitioned);


Node head20 = new Node (4);
Node head21 = new Node (1);
Node head22 = new Node (8);
Node head23 = new Node (4);
Node head24 = new Node(5);

head20.next = head21;
head21.next = head22;
head22.next = head23;
head23.next = head24;


Node head30 = new Node(5);
Node head31 = new Node (6);

head30.next = head31;
head31.next = head22;
head22.next = head23;
head23.next = head24;
        System.out.println("showing head20");
ll.show(head20);
        System.out.println("showing head30");
ll.show(head30);
Node intersect = ll.intersectionOf2LL(head20, head30);
        System.out.println("showing intersection");
ll.show(intersect);


        System.out.println("test for palindrome");
        Node head40 = new Node(1);
        Node head41 = new Node (2);
        Node head42 = new Node (2);
        Node head43 = new Node (0);

        head40.next = head41;
        head41.next = head42;
        head42.next = head43;

        boolean isPalindorme = ll.isPalindrome(head40);
        System.out.println("showing head40");
        ll.show(head40);
        System.out.println("Palindrome = "+ isPalindorme);
    }}