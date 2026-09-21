public class _12_recursion {

    /*
    * Problem 1 :-
    * Print 1 to n in increasing order
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void increasing(int n) {
        if(n == 0) {
            return ;
        }

        increasing(n-1);
        System.out.print(n + ", ");
    }

    /*
     * Problem 2 :-
     * Print n to 1 in decreasing order
     * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static void decreasing(int n) {
        if(n == 0) {
            return ;
        }

        System.out.print(n + ", ");
        decreasing(n-1);
    }

    /*
     * Problem 3 :-
     * WAF to return factorial of a number
     * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int factorial(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n-1) ;
    }

    /*
     * Problem 4 :-
     * WAF to print the Nth fibonacci number
     * Time Complexity :- O(2^n), Space Complexity :- O(n)*/
    public static int fibonacci(int n) {
        if(n < 0) {
            throw new IllegalStateException("Invalid index") ;
        }
        if(n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2) ;
    }

    /*
    * Problem 5 :-
    * Check if a given array is sorted or not
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static boolean isSorted(int[] arr, int i) {
        if((i+1) == arr.length) {
            return true ;
        }

        if(arr[i] > arr[i+1]) {
            return false ;
        }

        return isSorted(arr, i+1) ;
    }

    /*
    * Problem 6 :-
    * WAF to find the first occurrence of an element in an array
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int firstOccurrence(int[] arr, int idx, int key) {
        if(idx == arr.length) {
            return -1 ;
        }

        if(arr[idx] == key) {
            return idx ;
        }

        return firstOccurrence(arr, idx+1, key) ;
    }

    /*
    * Problem 7 :-
    * WAF to find the last occurrence of an element in an array
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int lastOccurrence(int[] arr, int idx, int key) {
        if(idx == arr.length) {
            return -1 ;
        }

        int res = lastOccurrence(arr, idx+1, key) ;

        if((res == -1) && (arr[idx] == key)) {
            res = idx ;
        }

        return res ;
    }

    /*
    * Problem 8 :-
    * WAF to get X^n
    * Time Complexity :- O(logN), Space Complexity :- O(n)*/
    public static int power(int x, int n) {
        if(n == 0) {
            return 1 ;
        }
        if(n == 1) {
            return x ;
        }

        int ans = power(x, n/2) ;

        if(n%2 != 0) {
            return ans * ans * x ;
        } else {
            return ans * ans ;
        }
    }

    /*
    * Problem 9 :-
    * Tiling Problem
    * Time Complexity :- O(2^n), Space Complexity :- O(n)*/
    public static int tilingProblem(int n) {
        if((n == 0) || (n == 1)) {
            return 1 ;
        }

        return tilingProblem(n-1) + tilingProblem(n-2) ;
    }


    // main function
    public static void main(String[] args) {

        // Test Case for Problem 9 :-
        System.out.println(tilingProblem(8));

        // Test Case for Problem 8 :-
//        System.out.println(power(2, 10));

        // Test Case for Problem 7 :-
//        int[] arr = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 987, 234, 23, 234, 234, 234, 234, 234, 86, 87, 86, 86} ;
//        System.out.println(lastOccurrence(arr, 0, 2));

        // Test Case for Problem 6 :-
//        int[] arr = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 987, 234, 23, 234, 234, 234, 234, 234, 86, 87, 86, 86} ;
//        System.out.println(firstOccurrence(arr, 0, 2));

        // Test Case for Problem 5 :-
//        int[] arr = {1, 2, 3, 11, 7} ;
//        int[] arr1 = {3, 2, 8, 9, 7} ;
//        System.out.println(isSorted(arr, 0));
//        System.out.println(isSorted(arr1, 0));

        // Test Case for Problem 4 :-
//        System.out.println(fibonacci(4));
//        System.out.println(fibonacci(3));
//        System.out.println(fibonacci(5));

        // Test Case for Problem 3 :-
//        System.out.println(factorial(5));
//        System.out.println(factorial(7));
//        System.out.println(factorial(4));

        // Test Case for Problem 2 :-
//        decreasing(5);
//        System.out.println();
//        decreasing(8);

        // Test Case for Problem 1 :-
//        increasing(5);
//        System.out.println();
//        increasing(7);
    }
}
