import java.util.ArrayList ;
import java.util.Stack ;

public class _18_Stack {

    /*
    * Problem 1 :-
    * Implement Stack using Array*/
    static class Stack_Array {
        int[] stack ;
        int size ;
        int top;
        Stack_Array(int size) {
            stack = new int[size] ;
            this.size = size ;
            top = -1 ;
        }

        // isEmpty
        public boolean isEmpty() {
            return top == -1 ;
        }

        // isFull
        public boolean isFull() {
            return top == (size-1) ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't peek element in empty Stack") ;
            }

            return stack[top] ;
        }

        // push
        public void push(int val) {
            if(isFull()) {
                throw new IllegalStateException("can't more element Stack is full") ;
            }

            stack[++top] = val ;
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty Stack") ;
            }

            return stack[top--] ;
        }
    }

    /*
    * Problem 2 :-
    * Implement Stack using ArrayList*/
    static class Stack_ArrayList {
        ArrayList<Integer> stack = new ArrayList<>() ;

        // isEmpty
        public boolean isEmpty() {
            return stack.isEmpty() ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't peek, Stack is empty") ;
            }

            return stack.get(stack.size()-1) ;
        }

        // push
        public void push(int val) {
            stack.add(val);
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty Stack") ;
            }

            return stack.remove(stack.size()-1) ;
        }
    }

    /*
    * Problem 3 :-
    * Implement Stack using LinkedList*/
    static class Node {
        int val ;
        Node next ;
        Node(int val) {
            this.val = val ;
            next = null ;
        }
    }

    static class Stack_LinkedList {
        Node head ;

        // isEmpty
        public boolean isEmpty() {
            return head == null ;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't peek element, Stack is empty") ;
            }

            return head.val ;
        }

        // push
        public void push(int val) {
            Node newNode = new Node(val) ;
            newNode.next = head ;
            head = newNode ;
        }

        // pop
        public int pop() {
            if(isEmpty()) {
                throw new IllegalStateException("Can't pop element from empty Stack") ;
            }

            int deleted_val = head.val ;
            head = head.next ;
            return deleted_val ;
        }
    }

    /*
    * Problem 4 :-
    * WAF to push an element at the bottom of the Stack
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void pushBottom(Stack<Integer> stack, int num) {
        if(stack.isEmpty()) {
            stack.push(num) ;
            return ;
        }

        int top = stack.pop() ;
        pushBottom(stack, num);
        stack.push(top) ;
    }

    /*
    * Problem 5 :-
    * Reverse Stack
    * Time Complexity :- O(n^2), Space Complexity :- O(n)*/
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return ;
        }

        int top = stack.pop() ;
        reverse(stack);
        pushBottom(stack, top);
    }

    /*
    * Problem 6 :-
    * Stock Span Problem
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int[] stockSpan(int[] price) {
        int n = price.length ;
        Stack<Integer> s = new Stack<>() ;
        int[] span = new int[n] ;
        s.push(0) ;
        span[0] = 1 ;
        for(int i = 1; i < n; i++) {
            while((!s.isEmpty()) && (price[s.peek()] <= price[i])) {
                s.pop() ;
            }
            if(s.isEmpty()) {
                span[i] = i+1 ;
            } else {
                span[i] = i-s.peek() ;
            }
            s.push(i) ;
        }

        return span ;
    }

    /*
    * Problem 7 :-
    * Next Greater Element
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static ArrayList<Integer> nextGreater_Right(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        Stack<Integer> s = new Stack<>() ;
        int n = arr.length-1 ;
        s.push(n) ;
        ans.add(-1) ;
        for(int i = (n-1); i >= 0; i--) {
            while((!s.isEmpty()) && (arr[s.peek()] <= arr[i])) {
                s.pop() ;
            }

            if(s.isEmpty()) {
                ans.addFirst(-1) ;
            } else {
                ans.addFirst(arr[s.peek()]) ;
            }

            s.push(i) ;
        }

        return ans ;
    }

    public static ArrayList<Integer> nextSmaller_Right(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        Stack<Integer> s = new Stack<>() ;
        int n = arr.length-1 ;
        s.push(n) ;
        ans.add(-1) ;
        for(int i = (n-1); i >= 0; i--) {
            while((!s.isEmpty()) && (arr[s.peek()] >= arr[i])) {
                s.pop() ;
            }

            if(s.isEmpty()) {
                ans.addFirst(-1) ;
            } else {
                ans.addFirst(arr[s.peek()]) ;
            }

            s.push(i) ;
        }
        System.out.println("nextSmaller_Right :- " + ans);
        return ans ;
    }

    public static ArrayList<Integer> nextSmaller_Left(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        Stack<Integer> s = new Stack<>() ;
        int n = arr.length ;
        s.push(0) ;
        ans.add(-1) ;
        for(int i = 1; i < n; i++) {
            while((!s.isEmpty()) && (arr[s.peek()] >= arr[i])) {
                s.pop() ;
            }

            if(s.isEmpty()) {
                ans.addFirst(-1) ;
            } else {
                ans.addFirst(arr[s.peek()]) ;
            }

            s.push(i) ;
        }
        System.out.println("nextSmaller_Left :- " + ans);
        return ans ;
    }

    /*
    * Problem 8 :-
    * Valid Parentheses
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static boolean isValidParentheses(String str) {
        Stack<Character> charStack = new Stack<>() ;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i) ;
            switch (ch) {
                case '(' :
                    charStack.push(')') ;
                    break;

                case '{' :
                    charStack.push('}') ;
                    break;

                case '[' :
                    charStack.push(']') ;
                    break;

                default :
                    if(charStack.isEmpty()) {
                        return false ;
                    }
                    if(charStack.peek() != ch) {
                        return false ;
                    }
                    charStack.pop() ;
            }
        }

        return true ;
    }

    /*
    * Problem 9 :-
    * Duplicate Parentheses
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> charStack = new Stack<>() ;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i) ;
            if(ch == ')') {
                int count = 0 ;
                while((!charStack.isEmpty()) && (charStack.peek() != '(')) {
                    charStack.pop() ;
                    count++ ;
                }

                if(count < 1) {
                    return true ;
                } else {
                    charStack.pop() ;
                }
            } else {
                charStack.push(ch) ;
            }
        }
        return false ;
    }

    /*
    * Problem 10 :-
    * Max Area in Histogram
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static int maxAreaInHistogram(int[] heights) {
        int n = heights.length ;
        int[] rs = nextSmaller_Right(heights).stream().mapToInt(Integer::intValue).toArray() ;
        int[] ls = nextSmaller_Left(heights).stream().mapToInt(Integer::intValue).toArray() ;
        return -1 ;
    }

    /*
    * Problem 11 :-
    * Remove Consecutive Characters
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static StringBuilder removeConsecutiveChar(String str) {
        Stack<Character> s = new Stack<>() ;
        s.push(str.charAt(0)) ;
        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i) ;
            if(s.peek() != ch) {
                s.push(ch) ;
            }
        }

        StringBuilder ans = new StringBuilder() ;
        while (!s.isEmpty()) {
            ans.append(s.pop()) ;
        }

        return ans.reverse() ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 11 :-
        String str = "aaaabbbbcddddeeeaaabcde" ;
        System.out.println(removeConsecutiveChar(str));

        // Test Case for Problem 10 :-
//        int[] height = {2, 1, 5, 6, 2, 3} ;
//        nextSmaller_Right(height) ;
//        nextSmaller_Left(height) ;

        // Test Case for Problem 9 :-
//        String str = "(((a+b)+(c+d)))" ;
//        System.out.println(isDuplicateParentheses(str));

        // Test Case for Problem 8 :-
//        String str = "((({[][]})))" ;
//        System.out.println(isValidParentheses(str));

        // Test Case for Problem 7 : -
//        int[] arr = {6, 8, 0, 1, 3} ;
//        ArrayList<Integer> response = nextGreater(arr) ;
//        System.out.println(response);

        // Test Case for Problem 6 :-
//        int[] price = {100, 80, 60, 70, 60, 85, 100} ;
//        int[] ans = stockSpan(price) ;

        // Test Case for Problem 5 :-
//        Stack<Integer> stack = new Stack<>() ;
//        stack.push(1) ;
//        stack.push(2) ;
//        stack.push(3) ;
//        stack.push(4) ;
//        System.out.println(stack.peek());
//        reverse(stack);
//        System.out.println(stack.peek());

        // Test Case for problem 5 :-
//        Stack<Integer> stack = new Stack<>() ;
//        stack.push(1) ;
//        stack.push(2) ;
//        stack.push(3) ;
//        pushBottom(stack, 4);
//        System.out.println(stack.peek());

        // Test Case for Problem 3 :-
//        Stack_LinkedList stackLinkedList = new Stack_LinkedList() ;
//        stackLinkedList.push(2);
//        stackLinkedList.push(98);
//        System.out.println(stackLinkedList.peek());

        // Test Case for Problem 2 :-
//        Stack_ArrayList stackArrayList = new Stack_ArrayList() ;
//        stackArrayList.push(1);
//        stackArrayList.push(2);
//        stackArrayList.push(3);
//        System.out.println(stackArrayList.peek());
//        System.out.println(stackArrayList.pop());
//        System.out.println(stackArrayList.pop());
//        System.out.println(stackArrayList.pop());
//        System.out.println(stackArrayList.isEmpty());

        // Test Case for Problem 1 :-
//        Stack_Array stackArray = new Stack_Array(5) ;
//        System.out.println(stackArray.isEmpty());
//        System.out.println(stackArray.isFull());
//        stackArray.push(2);
//        stackArray.push(3);
//        System.out.println(stackArray.pop());
//        System.out.println(stackArray.peek());
//        System.out.println(stackArray.isEmpty());
//        System.out.println(stackArray.pop());
//        System.out.println(stackArray.isEmpty());
    }
}
