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
    * Time Complexity :- O(?), Space Complexity :- O(?)*/
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return ;
        }
        int top = s.pop() ;
        reverseStack(s);
        pushAtBottom(s, top);
    }

    /*
    * Problem 4 :-
    * WAF to find the next greater element
    * Time Complexity :- O(?), Space Complexity :- O(?)*/
    public static int[] nextGreater(int[] arr) {
        int n = arr.length ;
        int[] ans = new int[n] ;

        Stack<Integer> s = new Stack<>() ;

        for(int i = (n-1); i >= 0; i--) {
            while((!s.isEmpty()) && (arr[s.peek()] <= arr[i])) {
                s.pop() ;
            }

            if(s.isEmpty()) {
                ans[i] = -1 ;
            } else {
                ans[i] = arr[s.peek()] ;
            }

            s.push(i) ;
        }

        return ans ;
    }

    /*
    * Problem 5 :-
    * valid Parentheses Problem
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static boolean isValid_Parentheses(String str) {
        Stack<Character> s = new Stack<>() ;
        int i = 0 ;
        while(i < (str.length())) {
            char ch = str.charAt(i) ;
            if((ch == '(') || (ch == '{') || (ch == '[')) {
                s.push(ch) ;
            } else {
                if(s.isEmpty()) {
                    return false ;
                }
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop() ;
                } else {
                    return false ;
                }
            }
            i++ ;
        }

        return s.isEmpty();
    }

    /*
    * Problem 6 :-
    * Duplicate Parentheses Problem
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static boolean isDuplicate_Parentheses(String str) {
        Stack<Character> s = new Stack<>() ;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i) ;

            if(ch == ')') {
                int count = 0 ;
                while(s.peek() != '(') {
                    s.pop() ;
                    count++ ;
                }

                if(count < 1) {
                    return true ;
                } else {
                    s.pop() ;
                }
            } else {
                s.push(ch) ;
            }
        }

        return false ;
    }

    public static void main(String[] args) {

        // Test Case for Problem 6 :-
//        String str = "(((a) + (b)))" ;
//        System.out.println(isDuplicate_Parentheses(str));

        // Test Case for Problem 5 :-
//        String str = "({[]})" ;
//        System.out.println(isValid_Parentheses(str));
//        String str = "]({})" ;
//        System.out.println(isValid_Parentheses(str)) ;

        // Test Case for Problem 4 :-
//        int[] arr = {6, 8, 0, 1, 3} ;
//        int[] res = nextGreater(arr) ;
//        for(int ele : res) {
//            System.out.print(ele + " ");
//        }
//        System.out.println();

        // Test Case for Problem 3 :-
//        Stack<Integer> s = new Stack<>() ;
//        s.push(1) ;
//        s.push(2) ;
//        s.push(3) ;
//        reverseStack(s);
//        while(!s.isEmpty()) {
//            System.out.println(s.pop());
//        }

        // Test Case for Problem 2 :-
//        String str = "abc" ;
//        StringBuilder sb = reverseString(str) ;
//        System.out.println(sb);
    }
}
