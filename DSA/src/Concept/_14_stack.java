package Concept;

import java.util.ArrayList;
import java.util.Stack;

class Stack_implementation {

    /*
    private ArrayList<Integer> stack = new ArrayList<>() ;

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    void push(int ele) {
        stack.addLast(ele);
    }

    public int pop() {
        if(stack.isEmpty()) {
            throw new Error("can't remove element from empty stack") ;
        }

        return stack.removeLast() ;
    }

    public int top() {
        return stack.getLast() ;
    }

    public void print() {
        while(!stack.isEmpty()) {
            System.out.println(stack.getLast());
            stack.removeLast() ;
        }
    }

     */

    Node top = null ;

    public boolean isEmpty() {
        return top == null;
    }

    void push(int ele) {
        Node newNode = new Node(ele) ;
        newNode.next = top ;
        top =  newNode ;
    }

    int pop() {
        if(top == null) {
            throw new Error("can't remove element from empty stack") ;
        }

        int val =  top.val ;
        top = top.next ;
        return val ;
    }

    int peek() {
        if(top == null) {
            throw new Error("stack is empty") ;
        }
        return top.val ;
    }

    void print() {
        Node temp = top ;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next ;
        }
    }
}

public class _14_stack {

    public static int[] stockSpanProblem(int[] stock) {

        Stack<Integer> stack = new Stack<>() ;
        int n = stock.length ;
        int[] span = new int[n] ;

        stack.push(0) ;
        span[0] = 1 ;

        for(int i = 1; i < n; i++) {
            while((!stack.isEmpty()) && (stock[i] >= stock[stack.peek()])) {
                stack.pop() ;
            }

            if(stack.isEmpty()) {
                span[i] = i+1 ;
            } else {
                span[i] = i-stack.peek() ;
            }
            stack.push(i) ;
        }

        return span ;
    }

    public static void main(String[] args) {
       int[] stock = {100, 80, 60, 70, 60, 85, 100} ;
        int[] span = stockSpanProblem(stock) ;

        for(int ele : span) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
