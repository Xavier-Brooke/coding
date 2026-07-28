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

    /*
    * Question 8 :-
    * WAF to find the first occurrence of the element
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int firstOccurrence(int[] arr, int key, int idx) {
        if(idx == arr.length) {
            return -1 ;
        }

        if(arr[idx] == key) {
            return idx ;
        }

        return firstOccurrence(arr, key, idx+1) ;
    }

    /*
    * Question 9 :-
    * WAF to find the last occurrence of an element
    * Time Complexity :- O(n), Space Complexity :- O(n)*/

    // Second Method
    public static int lastOccurrence(int[] arr, int key, int idx) {
        if(idx >= arr.length) {
            return -1 ;
        }

        int isFound = lastOccurrence(arr, key, idx+1) ;

        if((isFound ==  -1) && (arr[idx] == key)) {
            return idx ;
        }

        return isFound ;
    }
    /*
    First method
    public static int lastOccurrence(int[] arr, int key, int idx) {
        if(idx < 0) {
            return -1 ;
        }

        if(arr[idx] == key) {
            return idx ;
        }

        return lastOccurrence(arr, key, idx-1) ;
    }
     */

    /*
    * Question 10 :-
    * WAF to calculate x to the power n
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int power(int x, int n) {
        if(n == 0) {
            return 1 ;
        }
        return x * power(x, n-1) ;
    }

    /*
    * Question 11 :-
    * Write an optimized program to calculate x to the power n
    * Time Complexity :- O(logN), Space Complexity :- O(n) */
    public static int optimizedPower(int x, int n) {
        if(n == 0) {
            return 1 ;
        }

        int power = optimizedPower(x, n/2) ;

        if(n%2 == 0) {
            return power * power ;
        } else {
            return x * power * power ;
        }
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Question 11 :-
        int x = 2, y = 7 ;
        System.out.println(optimizedPower(x, y));

        // Test Case for Question 10 :-
//        int x = 2, y = 5 ;
//        System.out.println(power(2, 5));

        // Test Case for Question 9 :-
//        int[] arr = {8, 3, 6, 9, 5, 10, 2, 5, -3} ;
//        System.out.println(lastOccurrence(arr, 5, 0));

        // Test Case for Question 8 :-
//        int[] arr = {8, 3, 6, 9, 5, 10, 2, 5, -3} ;
//        System.out.println(firstOccurrence(arr, -3, 0));

        // Test Case for Question 7 :-
//        int[] arr1 = {1, 87, -234, 0, 234, 875} ;
//        System.out.println(isSorted(arr1, 0));
//        int[] arr2 = {1, 2, 3, 4, 5} ;
//        System.out.println(isSorted(arr2, 0));

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
