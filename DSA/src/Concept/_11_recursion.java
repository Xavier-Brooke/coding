package Concept;

public class _11_recursion {

    /*
    * Question 1 :-
    * WAF to print numbers in decreasing order
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void printDec(int n) {
        if(n == 0) {
            return ;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }

    /*
    * Question 2 :-
    * WAF to print numbers in increasing order
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void printInc(int x, int n) {
        if(x == n) {
            return ;
        }
        System.out.print(x + " ");
        printInc(x+1, n); ;
    }

    /*
    * Question 3 :-
    * WAF to print numbers in increasing order
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void printInc(int n) {
        if(n == 0) {
            return ;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    /*
    * Question 4 :-
    * WAF to print factorial of a number
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int factorial(int n) {
        if((n == 0) || (n == 1)) {
            return 1 ;
        }
        return n * factorial(n-1) ;
    }

    /*
    * Question 5 :-
    * WAF to print sum of n natural numbers
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int sumOfNaturalNum(int n) {
        if((n == 1)) {
            return 1 ;
        }
        return n + sumOfNaturalNum(n-1) ;
    }

    /*
    * Question 6 :-
    * WAF to print nth fibonacci numbers
    * Time Complexity :- O(2^n), Space complexity :- O(n)*/
    public static int fibonacci(int n) {
        if((n < 2) && (n >= 0)) {
            return n ;
        }
        return fibonacci(n-1) + fibonacci(n-2) ;
    }

    /*
    * Question 7 :-
    * WAF to check if an array is sorted or not
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static boolean isSorted(int[] arr, int idx) {
        if((idx+1) == arr.length) {
            return true ;
        }

        if(arr[idx] > arr[idx+1]) {
            return false ;
        }

        return isSorted(arr, idx+1) ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Question 7 :-
        int[] arr1 = {1, 87, -234, 0, 234, 875} ;
        System.out.println(isSorted(arr1, 0));
        int[] arr2 = {1, 2, 3, 4, 5} ;
        System.out.println(isSorted(arr2, 0));

        // Test Case for Question 6 :-
//        int fibo = fibonacci(8) ;
//        System.out.println("Fibonacci number at 5th idx is " + fibo);

        // Test Case for Question 5 :-
//        int sum = sumOfNaturalNum(10) ;
//        System.out.println("Sum of numbers from 1 to 10 is " + sum);

        // Test Case for Question 4 :-
//        int fact = factorial(5) ;
//        System.out.println("Factorial of 5 is " + fact);

        // Test Case for Question 3 :-
//        printInc(5) ;

        // Test Case for Question 2 :-
//        printInc(1, 5);

        // Test Case for Question 1 :-
//        printDec(5);
    }
}
