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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>() ;
        s.push(1) ;
        s.push(2) ;
        System.out.println(s.isEmpty());
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop() ;
        }
    }
}
