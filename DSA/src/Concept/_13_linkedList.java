package Concept;

class Node {
    int val ;
    Node next ;
    Node(int val) {
        this.val = val ;
        this.next = null ;
    }
}

class LinkedList {
    public Node head ;
    public Node tail ;
    public int size ;

    void addFirst(int val) {
        Node newNode = new Node(val) ;
        size++ ;
        if(head == null) {
            head = tail = newNode ;
            return ;
        }

        newNode.next = head ;
        head = newNode ;
    }

    void addLast(int val) {
        Node newNode = new Node(val) ;
        size++ ;
        if(head == null) {
            head = tail = newNode ;
            return ;
        }

        tail.next = newNode ;
        tail = newNode ;
    }

    void add(int idx, int val) {
        if(idx == 0) {
            this.addFirst(val);
            return ;
        }

        int i = 0 ;
        Node temp = head ;
        while(i < idx-1) {
            temp = temp.next ;
            i++ ;
        }

        Node newNode = new Node(val) ;
        newNode.next = temp.next ;
        temp.next = newNode ;
        size++ ;
    }

    int removeFirst() {
        if(size == 0) {
            throw new Error("Can't remove element from empty LinkedList") ;
        }
        int val = head.val ;
        head = head.next ;
        size-- ;
        return val;
    }

    int removeLast() {
        if(size == 0) {
            throw new Error("Can't remove element from empty LinkedList") ;
        } else if(size == 1) {
            int val = head.val ;
            head = tail = null ;
            size-- ;
            return val ;
        }

        Node temp = head ;
        for(int i = 0; i < (size-2); i++) {
            temp = temp.next ;
        }
        tail = temp ;
        int val = tail.next.val ;
        tail.next = null ;
        size-- ;
        return val ;
    }

    public int linearSearch(int key) {
        Node temp = head ;
        int i = 0 ;

        while(temp != null) {
            if(temp.val == key) {
                return i ;
            }
            i++ ;
            temp = temp.next ;
        }

        return -1 ;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1 ;
        }

        if(head.val == key) {
            return 0 ;
        }

        int idx = helper(head.next, key) ;

        if(idx == -1) {
            return -1 ;
        } else {
            return idx+1 ;
        }
    }

    public int recSearch(int key) {
        return helper(head, key) ;
    }

    public void reverse() {
        Node prev = null ;
        Node curr = tail = head ;
        Node next ;

        while(curr != null) {
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        head = prev ;
    }

    public void delete_nth_fromEnd(int n) {
        int sz = 0 ;
        Node temp = head ;
        while(temp != null) {
            temp = temp.next ;
            sz++ ;
        }

        if(sz == n) {
            head = head.next ;
            return ;
        }
    }

    public Node findMid(Node head) {
        Node slow = head ;
        Node fast = head ;

        while(fast != null && fast.next != null) {
            slow = slow.next ;
            fast = fast.next.next ;
        }

        return slow ;
    }

    public boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true ;
        }

        Node midNode = findMid(head) ;

        Node prev = null ;
        Node curr = midNode ;
        Node next ;

        while(curr != null) {
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Node right = prev ;
        Node left = head ;

        while(right != null) {
            if(right.val != left.val) {
                return false ;
            }

            right = right.next ;
            left = left.next ;
        }

        return true ;
    }

    // function to detect loop in LinkedList
    public boolean hasCycle() {
        Node slow = head ;
        Node fast = head ;

        while((fast != null) && (fast.next != null)) {
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast) {
                return true ;
            }
        }

        return false ;
    }

    public Node getNode(int idx) {
        Node temp = head ;
        int i = 0 ;
        while(i < idx) {
            temp = temp.next ;
            i++ ;
        }

        return temp ;
    }

    public void removeCycle() {
        Node slow = head ;
        Node fast = head ;
        boolean cycle = false ;

        while((fast != null) && (fast.next != null)) {
            slow = slow.next ;
            fast = fast.next.next ;

            if(slow == fast) {
                cycle = true ;
                break ;
            }
        }

        if(cycle == false) {
            return ;
        }

        slow = head ;
        Node prev = null ;
        while(slow != fast) {
            prev = fast ;
            slow = slow.next ;
            fast = fast.next ;
        }

        prev.next = null ;
    }

    void print() {
        Node temp = head ;
        if(temp == null) {
            System.out.println("null");
            return ;
        }
        while(temp != null) {
            System.out.print(temp.val + "->") ;
            temp = temp.next ;
        }
        System.out.print("null\n") ;
    }
}

public class _13_linkedList {

    // main function
    public static void main(String[] args) {
        LinkedList ll = new LinkedList() ;
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(3, 7);
        ll.addLast(-8);
        ll.tail.next = ll.head ;
        System.out.println(ll.hasCycle());
        ll.removeCycle();
        System.out.println(ll.hasCycle());
    }
}
