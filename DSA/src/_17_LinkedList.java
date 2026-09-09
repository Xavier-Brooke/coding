public class _17_LinkedList {

    static  class Node {
        int val ;
        Node next ;
        Node prev ;
        Node(int val) {
            this.val = val ;
            next = null ;
            prev = null ;
        }
    }

    static class LinkedList {
        Node head ;
        Node tail ;
        int size = 0 ;

        // addFirst
        public void addFirst(int val) {
            Node newNode = new Node(val) ;
            size++ ;

            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            newNode.next = head ;
            head = newNode ;
        }

        // addLast
        public void addLast(int val) {
            Node newNode = new Node(val) ;
            size++ ;

            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            tail.next = newNode ;
            tail = newNode ;
        }

        // add
        public void add(int idx, int val) {
            if(idx < 0 || idx > size) {
                throw new IllegalStateException("idx can't be less than 0 or greater than size of LinkedList") ;
            }

            if(idx == 0) {
                addFirst(val);
                return ;
            }

            if(idx == size) {
                addLast(val);
                return ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            Node newNode = new Node(val) ;
            newNode.next = itrNode.next ;
            itrNode.next = newNode ;
            size++ ;
        }

        // removeFirst
        public int removeFirst() {
            if(head == null) {
                throw new IllegalStateException("Can't remove element from empty LinkedList") ;
            }

            int removedVal = head.val;
            head = head.next ;
            if(head == null) {
                tail = null ;
            }
            size-- ;
            return removedVal ;
        }

        // removeLast
        public int removeLast() {
            if(head == null) {
                throw new IllegalStateException("Can't remove element from empty LinkedList") ;
            }

            if(head == tail) {
                return removeFirst() ;
            }

            Node itrNode = head ;
            while(itrNode.next != tail) {
                itrNode = itrNode.next ;
            }

            int removedVal = tail.val;
            itrNode.next = null ;
            tail = itrNode ;
            size-- ;
            return removedVal ;
        }

        // remove
        public int remove(int idx) {
            if(idx < 0 || idx >= size) {
                throw new IllegalStateException("idx can't be less than 0 or greater and equal to size") ;
            }

            if(idx == 0) {
                return removeFirst() ;
            }

            if(idx == (size-1)) {
                return removeLast() ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            int removedVal = itrNode.next.val;
            itrNode.next = itrNode.next.next ;
            size-- ;
            return removedVal ;
        }

        // linearSearch (loop)
        public boolean search(int key) {
            if(head == null) {
                return false ;
            }

            Node itrNode = head ;
            while(itrNode != null) {
                if(itrNode.val == key) {
                    return true ;
                }
                itrNode = itrNode.next ;
            }

            return false ;
        }

        // linearSearch (Recursive)
        public int search(Node head, int key) {
            if(head == null) {
                return -1 ;
            }

            if(head.val == key) {
                return 0 ;
            }

            int idx = search(head.next, key) ;

            if(idx == -1) {
                return -1 ;
            }

            return idx+1 ;
        }

        // reverse
        public void reverse() {
            if((head == null) || (head == tail)) {
                return;
            }

            Node curr = tail = head ;
            Node prev = null ;
            Node next ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next ;
            }
            head = prev ;
        }

        // Nth node from last
        public int nth_from_last(int n) {
            if(n <= 0 || n > size) {
                throw new IllegalStateException("n can't be less than or equal to 0, n can't be greater than size") ;
            }

            if(n == size) {
                return removeFirst() ;
            }
            if(n == 1) {
                return removeLast() ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < (size-n)) {
                itrNode = itrNode.next ;
                i++ ;
            }

            int removedVal = itrNode.next.val ;
            itrNode.next = itrNode.next.next ;
            size-- ;
            return removedVal ;
        }

        // Palindrome
        public boolean isPalindrome() {
            if((head == null) || (head == tail)) {
                return true ;
            }

            Node slow = head ;
            Node fast = head ;
            while ((fast != null) && (fast.next != null)) {
                slow = slow.next ;
                fast = fast.next.next ;
            }

            Node curr = slow.next ;
            Node prev = slow ;
            slow.next = null ;
            Node next ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next ;
            }

            Node leftHead = head ;
            Node rightHead = prev ;
            while(rightHead != null) {
                if(leftHead.val != rightHead.val) {
                    return false ;
                }
                leftHead = leftHead.next ;
                rightHead = rightHead.next ;
            }

            return true ;
        }

        // getNode
        public Node getNode(int idx) {
            if((idx < 0) || (idx >= size)) {
                throw new IllegalStateException("idx can't be less than 0 or greater than size") ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            return itrNode ;
        }

        // detect loop
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

        // remove cycle
        public void removeCycle() {
            if(!hasCycle()) {
                System.out.println("LinkedList has no cycle, returning without operation");
                return ;
            }

            System.out.println("LinkedList has cycle, starting operation");
            Node slow = head ;
            Node fast = head ;
            while((fast != null) && (fast.next != null)) {
                slow = slow.next ;
                fast = fast.next.next ;
                if(slow == fast) {
                    break ;
                }
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

        // zigZag
        public void zigZag() {
            if((head == null) || (head == tail) || (head.next == tail)) {
                return ;
            }

            Node slow = head ;
            Node fast = head.next ;
            while((fast != null) && (fast.next != null)) {
                slow = slow.next ;
                fast = fast.next.next ;
            }

            Node curr = slow.next ;
            Node prev = null ;
            slow.next = null ;
            Node next ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                prev = curr ;
                curr = next ;
            }

            Node leftHead = head ;
            Node rightHead = prev ;
            Node nextLeftHead, nextRightHead ;
            while(rightHead != null) {
                nextLeftHead = leftHead.next ;
                leftHead.next = rightHead ;
                leftHead = nextLeftHead ;

                nextRightHead = rightHead.next ;
                rightHead.next = leftHead ;
                rightHead = nextRightHead ;
            }
        }

        // print
        public void print() {
            if(head == null) {
                System.out.println("null") ;
                return ;
            }

            Node itrNode = head ;
            while(itrNode != null) {
                System.out.print(itrNode.val + "->") ;
                itrNode = itrNode.next ;
            }
            System.out.print("null\n") ;
        }
    }

    static class DoubleLL {
        Node head ;
        Node tail ;
        int size = 0 ;

        // addFirst
        public void addFirst(int val) {
            Node newNode = new Node(val) ;
            size++ ;
            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            head.prev = newNode ;
            newNode.next = head ;
            head = newNode ;
        }

        // addLast
        public void addLast(int val) {
            Node newNode = new Node(val) ;
            size++ ;
            if(head == null) {
                addFirst(val);
                return ;
            }

            tail.next = newNode ;
            newNode.prev = tail ;
            tail = newNode ;
        }

        // add
        public void add(int idx, int val) {
            if(idx < 0 || idx >= size) {
                throw new IllegalStateException("invalid idx") ;
            }

            if(idx == 0) {
                addFirst(val);
                return ;
            } else if(idx == size) {
                addLast(val);
                return ;
            }

            Node itrNode = head ;
            int i = 1 ;
            while(i < idx) {
                itrNode = itrNode.next ;
                i++ ;
            }

            Node newNode = new Node(val) ;
            newNode.next = itrNode.next ;
            itrNode.next.prev = newNode ;
            newNode.prev = itrNode ;
            itrNode.next = newNode ;
            size++ ;
        }

        // reverse
        public void reverse() {
            if((head == null) || (head.next == null)) {
                return ;
            }

            Node curr = tail = head ;
            Node prev = null ;
            Node next ;
            while(curr != null) {
                next = curr.next ;
                curr.next = prev ;
                curr.prev = next ;
                prev = curr ;
                curr = next ;
            }
            head = prev ;
        }

        // print
        public void print() {
            if(head == null) {
                System.out.println("null");
                return ;
            }

            Node itrNode = head ;
            while(itrNode != null) {
                System.out.print(itrNode.val + "<->");
                itrNode = itrNode.next ;
            }
            System.out.println("null");
        }

        // print
        public void print(boolean reverse) {
            if(!reverse) {
                print() ;
                return ;
            }

            Node itrNode = tail ;
            while(itrNode != null) {
                System.out.print(itrNode.val + "<->");
                itrNode = itrNode.prev ;
            }
            System.out.println("null");
        }
    }

    // main function
    public static void main(String[] args) {

        // DoubleLL Createion, basic operation and different test cases
        DoubleLL doubleLL = new DoubleLL() ;
        doubleLL.addLast(1);
        doubleLL.addLast(2);
        doubleLL.addLast(3);
        doubleLL.addFirst(0);

        doubleLL.print();
        doubleLL.reverse();
        doubleLL.print();

//        doubleLL.print();
//        doubleLL.print(true);
//        doubleLL.print(false);

        // LinkedList Creation, basic operation and different test Cases
//        LinkedList ll = new LinkedList() ;
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);
//
//        ll.print();
//        ll.zigZag();
//        ll.print();

//        ll.removeCycle();
//        ll.tail.next = ll.getNode(2) ;
//        ll.removeCycle();
//        ll.removeCycle();

//        System.out.println(ll.hasCycle());
//        ll.tail.next = ll.getNode(2) ;
//        System.out.println(ll.hasCycle());

//        ll.print();
//        System.out.println(ll.isPalindrome());

//        System.out.println(ll.nth_from_last(1));
//        ll.print();
//        System.out.println(ll.nth_from_last(3));

//        System.out.println(ll.removeFirst());
//        System.out.println(ll.removeLast());
//        System.out.println(ll.remove(2));
//        ll.print();

//        System.out.println(ll.search(5));
//        System.out.println(ll.search(234));
//        System.out.println(ll.search(ll.head, 87));
//        System.out.println(ll.search(ll.head, 2));

//        System.out.print("LinkedList before reverse :- ") ;
//        ll.print();
//        System.out.print("LinkedList after reverse :- ") ;
//        ll.reverse();
//        ll.print();
    }
}
