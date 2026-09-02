package Concept;

import java.util.LinkedList;
import java.util.Queue;

public class _17_queue {

    static class Queue_Array {
        int[] arr ;
        int size ;
        int rear ;
        Queue_Array(int size) {
            this.size = size ;
            arr = new int[size] ;
            rear = -1 ;
        }

        // isEmpty
        public boolean isEmpty() {
            return rear == -1 ;
        }

        // peek
        public int peek() {
            if(rear == -1) {
                throw new IllegalStateException("Can't get peek, Queue is empty") ;
            }

            return arr[0] ;
        }

        // add
        public void add(int val) {
            if(rear == arr.length-1) {
                throw new ArrayStoreException("Can't store element, Queue is full") ;
            }
            arr[++rear] = val ;
        }

        // remove
        public int remove() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't remove element from empty Queue") ;
            }

            int removedEle = arr[0] ;
            for(int i = 0; i < rear; i++) {
                arr[i] = arr[i+1] ;
            }
            --rear ;

            return removedEle ;
        }
    }

    static class Circular_Queue {
        int[] arr ;
        int size ;
        int front ;
        int rear ;

        Circular_Queue(int size) {
            this.size = size ;
            arr = new int[size] ;
            front = rear = -1 ;
        }

        // empty
        public boolean isEmpty() {
            return (front == -1) && (rear == -1) ;
        }

        // isFull
        public boolean isFull() {
            return (rear+1)%size == front ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get peek, Circular Queue is empty") ;
            }

            return arr[front] ;
        }

        // add
        public void add(int val) {
            if((rear == size-1) || (rear+1 == front)) {
               throw new IllegalStateException("Can't add element in Circular Queue, Circular Queue is full") ;
            }
            rear = (rear+1)%size ;
            arr[rear] = val ;
        }

        // remove
        public int remove() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get peek, Circular Queue is empty") ;
            }

            int val = arr[front] ;
            if(front == rear) {
                front = rear = -1 ;
            } else {
                front = (front+1)%size ;
            }

            return val ;
        }
    }

    static class Node {
        int val ;
        Node next ;
        Node(int val) {
            this.val = val ;
            next = null ;
        }
    }

    static class Queue_LinkedList {
        Node head ;
        Node tail ;

        // isEmpty
        public boolean isEmpty() {
            return head != null ;
        }

        // peek
        public int peek() {
            if(head == null) {
                throw new IllegalStateException("Can't get peek, Queue is empty") ;
            }

            return head.val ;
        }

        // add
        public void add(int val) {
            Node newNode = new Node(val) ;
            if(head == null) {
                head = tail = newNode ;
                return ;
            }

            tail.next = newNode ;
            tail = newNode ;
        }

        // remove
        public int remove() {
            if(head == null) {
                throw new IllegalStateException("Can't remove element from Queue, Queue is empty") ;
            }

            int removed_Ele = head.val ;
            head = head.next ;
            return removed_Ele ;
        }
    }

    public static void main(String[] args) {

        // Queue using Array
        Queue_Array q = new Queue_Array(5) ;
        Queue<Integer> query = new LinkedList<>() ;
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(7);
        q.remove() ;
        System.out.println(q.peek());
    }
}
