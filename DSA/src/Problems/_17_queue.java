package Problems;

import java.lang.reflect.Array;
import java.util.*;

public class _17_queue {

    /*
    * Problem 1 :-
    * Implement Queue using 2 Stacks
    * Time Complexity :- O(), Space Complexity :- O()*/
    static class Queue_Stack_1 {
        Stack<Integer> s1 = new Stack<>() ;
        Stack<Integer> s2 = new Stack<>() ;

        // isEmpty
        public boolean isEmpty() {
            return s1.isEmpty() ;
        }

        // push
        public void push(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop()) ;
            }

            s1.push(data) ;

            while(!s2.isEmpty()) {
                s1.push(s2.pop()) ;
            }
        }

        // peek
        public int peek() {
            if(s1.isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty queue") ;
            }

            return s1.peek() ;
        }

        // pop
        public int pop() {
            if(s1.isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty queue") ;
            }

            return s1.pop() ;
        }
    }

    public static class Queue_Stack_2 {
        Stack<Integer> s1 = new Stack<>() ;
        Stack<Integer> s2 = new Stack<>() ;

        // isEmpty
        public boolean isEmpty() {
            return s1.isEmpty() ;
        }

        // push
        public void push(int val) {
            s1.push(val) ;
        }

        // pop
        public int pop() {

            if(s1.isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty Queue") ;
            }

            while(!s1.isEmpty()) {
                s2.push(s1.pop()) ;
            }

            int val = s2.pop() ;

            while(!s2.isEmpty()) {
                s1.push(s2.pop()) ;
            }

            return val ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get the peek of an empty Queue") ;
            }

            while(!s1.isEmpty()) {
                s2.push(s1.pop()) ;
            }

            int val = s2.peek() ;

            while(!s2.isEmpty()) {
                s1.push(s2.pop()) ;
            }

            return val ;
        }
    }

    public static ArrayList<Character> nonRepeating(String str) {
        Queue<Character> q = new LinkedList<>() ;
        int[] freq = new int[26] ;
        ArrayList<Character> ans = new ArrayList<>() ;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i) ;
            freq[ch-'a']++ ;
            q.add(ch) ;

            while((!q.isEmpty()) && (freq[q.peek() - 'a'] > 1)) {
                q.remove() ;
            }

            if(q.isEmpty()) {
                ans.add('#') ;
            } else {
                ans.add(q.peek()) ;
            }
        }

        return ans ;
    }

    /*
    * Problem 4 :-
    * Interleave 2 Halves of a Queue (even length)*/
    public static void interleave(Queue<Integer> q1) {
        Queue<Integer> q2 = new LinkedList<>() ;
        int size = q1.size() ;

        for(int i = 0; i < size/2; i++) {
            q2.add(q1.remove()) ;
        }

        while(!q2.isEmpty()) {
            q1.add(q2.remove()) ;
            q1.add(q1.remove()) ;
        }
    }

    /*
    * Problem 5 :-
    * WAF to reverse a Queue*/
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>() ;
        while (!q.isEmpty()) {
            s.add(q.remove()) ;
        }
        while(!s.isEmpty()) {
            q.add(s.pop()) ;
        }
    }

    /*
    * Problem 6 :-
    * Implement Queue through Deque*/
    static class Queue_Deque {
        Deque<Integer> dq = new LinkedList<>() ;

        // isEmpty
        public boolean isEmpty() {
            return dq.isEmpty() ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't get the peek of empty queue") ;
            }

            return dq.getFirst() ;
        }

        // push
        public void push(int val) {
            dq.addLast(val);
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element form empty Queue") ;
            }

            return dq.removeFirst() ;
        }
    }


    public static void main(String[] args) {

        // Test Case for Problem 6 :-
        Queue_Deque q = new Queue_Deque() ;
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());

        // Test Case for Question 5 :-
//        Queue<Integer> q = new LinkedList<>() ;
//        q.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) ;
//        System.out.println(q.peek());
//        reverseQueue(q);
//        System.out.println(q.peek());

        // Test Case for Question 4 :-
//        Queue<Integer> q = new LinkedList<>() ;
//        q.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) ;
//        interleave(q);
//        while(!q.isEmpty()) {
//            System.out.print(q.remove() + ",");
//        }

//        String str = "aabccxb" ;
//        ArrayList<Character> ans = nonRepeating(str) ;
//        System.out.println(ans);

//        Queue_Stack_2 q1 = new Queue_Stack_2() ;
//        q1.push(1);
//        q1.push(2);
//        q1.push(3);
//        System.out.println(q1.pop());
//        System.out.println(q1.peek());

//        Queue_Stack_1 q1 = new Queue_Stack_1() ;
//        q1.push(1);
//        q1.push(2);
//        q1.push(3);
//        System.out.println(q1.pop());
//        System.out.println(q1.peek());
    }
}
