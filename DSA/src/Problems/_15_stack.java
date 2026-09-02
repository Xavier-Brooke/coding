package Problems;

import java.util.Queue;
import java.util.Deque ;
import java.util.LinkedList;

public class _15_stack {

    /*
    * Problem 1 :-
    * Stack Implementation using 2 Queues*/
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>() ;
        Queue<Integer> q2 = new LinkedList<>() ;

        // isEmpty
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty() ;
        }

        // push
        public void push(int val) {
            if(!q1.isEmpty()) {
                q1.add(val) ;
            } else {
                q2.add(val) ;
            }
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element form empty queue") ;
            }

            int popped_val = Integer.MAX_VALUE ;
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    popped_val = q1.remove() ;
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(popped_val) ;
                }
            } else {
                while(!q2.isEmpty()) {
                    popped_val = q2.remove() ;
                    if(q2.isEmpty()) {
                        break ;
                    }
                    q1.add(popped_val) ;
                }
            }

            return popped_val ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get peek for an empty Stack") ;
            }
            int peek_ele = Integer.MIN_VALUE ;
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    peek_ele = q1.remove() ;
                    q2.add(peek_ele) ;
                }
            } else {
                while(!q2.isEmpty()) {
                    peek_ele = q2.remove() ;
                    q1.add(peek_ele) ;
                }
            }

            return peek_ele ;
        }
    }

    /*
    * Problem 2 :-
    * Stack Implementation using Deque*/
    static class Stack_Deque {
        Deque<Integer> dq = new LinkedList<>() ;

        // isEmpty
        public boolean isEmpty() {
            return dq.isEmpty() ;
        }

        // push
        public void push(int val) {
            dq.addLast(val);
        }

        // pop
        int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't remove element from a emtpy stack") ;
            }

            return dq.removeLast() ;
        }

        // peek
        int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't remove element from a emtpy stack") ;
            }

            return dq.getLast() ;
        }
    }

    public static void  main(String[] args) {

        // Test Case for Problem 2 :-
        Stack_Deque s = new Stack_Deque() ;
        s.push(1);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.peek());
        s.pop() ;
        System.out.println(s.peek());

//        Stack s1 = new Stack() ;
//        System.out.println(s1.isEmpty());
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//
//        while (!s1.isEmpty()) {
//            System.out.println(s1.pop());
//        }
    }
}
