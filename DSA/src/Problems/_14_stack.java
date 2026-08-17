package Problems;

import java.util.Stack ;

public class _14_stack {

    /*
    * Problem 1 :-
    * WAF to push an element at the bottom of the sack
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void pushAtBottom(Stack<Integer> s, int val) {
        if(s.isEmpty()) {
            s.push(val) ;
            return ;
        }

        int top = s.pop() ;
        pushAtBottom(s, val);
        s.push(top) ;
    }

    /* Problem 2 :-
    * WAF to reverse a string using Stack
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static StringBuilder reverseString(String str) {
        Stack<Character> charStack = new Stack<>() ;
        int i = 0 ;
        while(i < (str.length())) {
            charStack.push(str.charAt(i)) ;
            i++ ;
        }

        StringBuilder sb = new StringBuilder( );
        while(!charStack.isEmpty()) {
            sb.append(charStack.pop()) ;
        }

        return sb ;
    }

    /*
    * Problem 3 :-
    * WAF to reverse Stack
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return ;
        }
        int top = s.pop() ;
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void main(String[] args) {

        // Test Case for Problem 3 :-
        Stack<Integer> s = new Stack<>() ;
        s.push(1) ;
        s.push(2) ;
        s.push(3) ;
        reverseStack(s);
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }

        // Test Case for Problem 2 :-
//        String str = "abc" ;
//        StringBuilder sb = reverseString(str) ;
//        System.out.println(sb);
    }
}
