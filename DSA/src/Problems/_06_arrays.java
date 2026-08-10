package Problems;

public class _06_arrays {

    /* 1D Array */

    /*
    * Problem 1 :-
    * WAF to merge two sorted arrays
    * Time Complexity :- O(max(m,n)), Space Complexity :- O(m+n)*/
    public static int[] mergeArr(int[] a, int[] b) {
        int m = a.length ;
        int n = b.length ;
        int[] ans = new int[m+n] ;

        int p = 0 ;
        int q = 0;
        int r = 0 ;
        while((p < m) || (q < n)) {
            if((p < m) && (q < n)) {
                if(a[p] <= b[q]) {
                    ans[r] = a[p] ;
                    p++ ;
                } else {
                    ans[r] = b[q] ;
                    q++ ;
                }
            } else if(p < m) {
                ans[r] = a[p] ;
                p++ ;
            } else if(q < n) {
                ans[r] = b[q] ;
                q++ ;
            }
            r++ ;
        }

        return ans ;
    }

    /*
    * Problem 2 :-
    * WAF to sort 0s, 1s and 2s
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void sort_0s_1s_2s(int[] arr) {
        int i = 1 ;
        int j = arr.length-1 ;
        int p = 1 ;
        int q = arr.length-1 ;
        while((i < j) || (p < q)) {
            if(i < j) {
                if(((arr[j] == 0) || (arr[j] == 1)) && (arr[i] == 2)) {
                    int temp = arr[j] ;
                    arr[j] = arr[i] ;
                    arr[i] = temp ;
                    i++ ;
                    j-- ;
                } else if(arr[j] == 2) {
                    j-- ;
                } else if((arr[i] == 0) || (arr[i] == 1)) {
                    i++ ;
                }
            }

            if(p < q) {
                if((arr[p] == 1) && (arr[q] == 0)) {
                    int temp = arr[p] ;
                    arr[p] = arr[q] ;
                    arr[q] = temp ;
                    p++ ;
                    q-- ;
                } else if(arr[p] == 0) {
                    p++ ;
                } else if((arr[q] == 1) || (arr[q] == 2)) {
                    q-- ;
                }
            }
        }
    }

    /*
    * Problem 3 :-
    * WAF to segregate 0s and 1s
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void segregate0and1(int[] arr) {
        int n = arr.length ;
        int si = 0 ;
        int ei = n-1 ;
        while(si < ei) {
            if((arr[si] == 1) && (arr[ei] == 0)) {
                int temp = arr[si] ;
                arr[si] = arr[ei] ;
                arr[ei] = temp ;
                si++ ;
                ei-- ;
            } else if(arr[si] == 0) {
                si++ ;
            } else if(arr[ei] == 1) {
                ei-- ;
            }
        }
    }

    /*
    * Problem 4 :-
    * WAF to print wavy array
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void wavyArray(int[] arr) {
        int n = arr.length ;
        int i = 0 ;

        while((i < n) && (i != n-1)) {
            int currIdx = i ;
            int nexIdx = ++i ;
            int temp = arr[currIdx] ;
            arr[currIdx] = arr[nexIdx] ;
            arr[nexIdx] = temp ;
            i++ ;
        }
    }

    /* 2D Array */

    public static void printArr_2D(int[][] matrix) {
        for(int[] arr : matrix) {
            for(int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    * Problem 1 :-
    * WAF to print array column wise
    * Time Complexity :-  O(n^2), Space Complexity :- O(1)*/
    public static void printArr_columnWise(int[][] arr) {
        int rows = arr.length ;
        int cols = arr[0].length ;
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

    /*
    * Problem 2 :-
    * WAF to reverse every row of the matrix
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void reverseRow(int[][] matrix) {
        for(int i=0; i < matrix.length; i++) {
            int si = 0 ;
            int ei = matrix[i].length-1 ;
            while (si < ei) {
                int temp = matrix[i][si] ;
                matrix[i][si] = matrix[i][ei] ;
                matrix[i][ei] = temp ;
                si++ ;
                ei-- ;
            }
        }
    }

    /*
    * Problem 3 :-
    * WAF to print matrix in Snake Pattern
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void snakePattern(int[][] matrix) {
        for(int col = 0; col < matrix[0].length; col++) {
            int idx = (col%2 == 0) ? 0 : matrix.length-1 ;
            if(idx == 0) {
                for(int row = idx; row < matrix.length; row++) {
                    System.out.print(matrix[row][col] + " ");
                }
            } else {
                for(int row = idx; row >= 0; row--) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }

    /*
    * Problem 4 :-
    * WAF to return transpose of a matrix
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static int[][] transpose(int[][] a) {
        int m = a.length ;
        int n = a[0].length ;

        int[][] b = new int[m][n] ;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                b[i][j] = a[j][i] ;
            }
        }

        return b ;
    }

    /*
    * Problem 5 :-
    * WAF to multiply two matrices
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int m = A.length ;
        int n = A[0].length ;
        int p = B.length ;
        int q = B[0].length ;

        if(n != p) {
            throw new Error("Can't multiply matrices") ;
        }

        int[][] C = new int[m][q] ;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < q; j++) {
                int mulSum = 0 ;
                for(int k = 0; k < n; k++) {
                  mulSum += A[i][k] * B[k][j] ;
                }
                C[i][j] = mulSum ;
            }
        }

        return C ;
    }

    // main function
    public static void main(String[] args) {

        /* 2D Arrays */

        // Test Case for Problem 5 :-
        int[][] A = {{1, 2}, {3, 4}, {5, 6}} ;
        int[][] B = {{2, 1}, {4, 2}} ;
        int[][] C = multiplyMatrices(A, B) ;
        for(int[] arr : C) {
            for(int ele : arr) {
                System.out.print(ele + " ") ;
            }
            System.out.println();
        }
        System.out.println();

        // Test Case for Problem 4 :-
//        int[][] arr = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}} ;
//        printArr_2D(transpose(arr));

        // Test Case for Problem 3 :-
//        int[][] arr = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}} ;
//        snakePattern(arr);

        // Test Case for Problem 2 :-
//        int[][] arr = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}} ;
//        reverseRow(arr);
//        printArr_2D(arr);


        // Test Case for Problem 1 :-
//        int[][] arr = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}} ;
//        printArr_columnWise(arr);

        /* 1D Arrays */

        // Test Case for Problem 4 :-
//        int[] arr = {2, 4, 7, 8, 9, 10} ;
//        wavyArray(arr);
//        printArr(arr);

        // Test Case for Problem 3 :-
//        int[] arr = {0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0} ;
//        segregate0and1(arr);
//        printArr(arr) ;

        // Test Case for Problem 2 :-
//        int[] arr = {0, 1, 1, 1, 2, 0, 0, 0, 2} ;
//        sort_0s_1s_2s(arr);

        // Test Case for Problem 1 :-
//        int[] a = {1, 3, 5, 7, 9} ;
//        int[] b = {2, 4, 6, 8, 10} ;
//        int[] c = mergeArr(a, b) ;
//        for(int ele : arr) {
//            System.out.print(ele + " ");
//        }
    }
}
