package Concept;

public class _06_arrays {

    /* 1D Arrays */

    // function for printing array
    public static void printArr(int[] arr) {
        for(int ele : arr) {
            System.out.print(ele + ",");
        }
        System.out.println() ;
    }

     /*
     * Question 1 :-
     * WAF to find a given target in an array (Linear Search)
     * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i ;
            }
        }
        return -1 ;
    }

    /*
    * Question 2 :-
    * WAF to find the largest number in an array
    * Time Complexity :- O(n), Space Complexity :- O(1) */
    public static int largestElement(int[] arr) {
        int max = Integer.MIN_VALUE ;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i] ;
            }
        }
        return max ;
    }

    /*
    * Question 3 :-
    * WAF to find the smallest number in an array
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int smallestElement(int[] arr) {
        int min = Integer.MAX_VALUE ;
        for(int ele : arr) {
            if(ele < min) {
                min = ele ;
            }
        }
        return min ;
    }

    /*
    * Question 4 :-
    * WAF for Binary Search
    * Time Complexity :- O(log n), Space Complexity :- O(1)
    * Note :- for Binary Search to work properly the array should be sorted*/
    public static int binarySearch(int[] arr, int target) {
        int i = 0 ;
        int j = arr.length-1 ;
        while(i <= j) {
            int mid =    (i+j)/2 ;
            if(arr[mid] == target) {
                return mid ;
            } else if(arr[mid] < target) {
                i = mid+1 ;
            } else {
                j = mid-1 ;
            }
        }
        return -1 ;
    }

    /*
    * Question 5 :-
    * WAF to reverse an array
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void reverseArr(int[] arr) {
        int si = 0 ;
        int ei = arr.length-1 ;
        while(si < ei) {
            int temp = arr[si] ;
            arr[si] = arr[ei] ;
            arr[ei] = temp ;
            si++ ;
            ei-- ;
        }
    }

    public static void reverseArr(int[] arr, int si, int ei) {
        while(si <= ei) {
            int temp = arr[si] ;
            arr[si] = arr[ei] ;
            arr[ei] = temp ;
            si++ ;
            ei-- ;
        }
    }

    /*
    * Question 6 :-
    * WAF to print pairs in an array
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void printPairs(int[] arr) {
        int n = arr.length ;
        for(int i = 0; i < (n-1); i++) {
            for(int j = (i+1); j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + "),");
            }
            System.out.println();
        }
    }

    /*
    * Question 7 :-
    * WAF to print subarrays of an array
    * Time Complexity :- O(n^3), Space Complexity :- O(1)*/
    public static void printSubarray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    * Question 8 :-
    * WAF to print max sum of all possible subarray of an array
    * Time Complexity :- O(n^3), Space Complexity :- O(1)*/
    public static int max_subArray_sum_bruteforce(int[] arr) {
        int maxSum = Integer.MIN_VALUE ;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int currSum = 0 ;
                for(int k = i; k <= j; k++) {
                    currSum += arr[k] ;
                }
                maxSum = Math.max(maxSum, currSum) ;
            }
        }
        return maxSum;
    }

    /*
    * Question 9 :-
    * WAF to print max sum of all possible subarray of an array
     * Time Complexity :- O(n^2), Space Complexity :- O(n)*/
    public static int max_sumArray_sum_prefixArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE ;

        int n = arr.length ;
        int[] prefixSum = new int[n] ;
        prefixSum[0] = arr[0] ;
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i] ;
        }

        int currSum = 0 ;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                currSum = (i == 0) ? prefixSum[j] : (prefixSum[j] - prefixSum[i-1]) ;
                maxSum = Math.max(maxSum, currSum) ;
            }
        }
        return maxSum ;
    }

    /*
     * Question 10 :-
     * WAF to print max sum of all possible subarray of an array
     * Time Complexity :- O(n), Space Complexity :- O(1)
     * Note :- This algorithm will not work for negative maxSum*/
    public static int max_sumArray_sum_kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE ;

        int currSum = 0 ;

        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i] ;
            if(currSum < 0) {
                currSum = 0 ;
            }
            maxSum = Math.max(maxSum, currSum) ;
        }

        return maxSum ;
    }

    /*
    * Question 11 :-
    * WAF to rotate an array about a pivot point
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void rotateArr(int[] arr, int d) {
        int n = arr.length ;
        d %= n ;
        reverseArr(arr, 0, n-1);
        reverseArr(arr, 0, n-d-1);
        reverseArr(arr, n-d, n-1);
    }

    /*
    * Question 12 :-
    * Trapping Rain water
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int trappingRainWater(int[] heights) {
        int n = heights.length ;
        int trappedWater = 0 ;

        int[] rightMax = new int[n] ;
        int[] leftMax = new int[n] ;

        leftMax[0] = heights[0] ;
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(heights[i], leftMax[i-1]) ;
        }

        rightMax[n-1] = heights[n-1] ;
        for(int i = (n-2); i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i+1]) ;
        }

        for(int i = 0; i < n; i++) {
            int waterLevel = Math.min(rightMax[i], leftMax[i]) ;
            trappedWater += (waterLevel - heights[i]) ;
        }
        return trappedWater ;
    }

    /*
    * Question 13 :-
    * Stock Buy and Sell problem
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int stockBuyAndSell(int[] prices) {
        int maxProfit = 0 ;
        int buyingPrice = prices[0] ;
        for(int i = 1; i < prices.length; i++) {
            if(buyingPrice < prices[i]) {
                int currProfit = prices[i] - buyingPrice ;
                maxProfit = Math.max(currProfit, maxProfit) ;
            } else {
                buyingPrice = prices[i] ;
            }
        }
        return maxProfit ;
    }

    /* 2D Arrays */

    /*
    * Question 1 :-
    * WAF to apply concept of linear search on 2D matrices
    * Time Complexity :- O(m*n), Space Complexity :- O(1)*/
    public static void linearSearch_2D_matrices(int[][] matrix, int key) {
        for(int i =  0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == key) {
                    System.out.println(key + " is present in matrix, at (" + i + "," + j + ")") ;
                    return ;
                }
            }
        }
        System.out.println(key + " is not present in matrix") ;
        return ;
    }

    /*
    * Question 2 :-
    * WAF to print matrix in spiral way
    * Time Complexity :- O(m*n), Space Complexity :- O()*/
    public static void spiralMatrix(int[][] matrix) {
        int sr = 0 ; // Starting row
        int er = matrix.length-1 ; // ending row
        int sc = 0 ; // starting column
        int ec = matrix[0].length-1 ; // ending column

        while((sc <= ec) && (sr <= er)) {
            // horizontally towards right
            for(int p = sc; p <= ec; p++) {
                System.out.print(matrix[sr][p] + " ") ;
            }
            // vertically towards bottom
            for(int q = (sr+1); q <= er; q++) {
                System.out.print(matrix[q][ec] + " ");
            }
            // horizontally towards left
            if(sr < er) {
                for(int r = (ec-1); r >= sc; r--) {
                    System.out.print(matrix[er][r] + " ");
                }
            }
            // vertically towards up
            if(sc < ec) {
                for(int s = (er-1); s >= (sr+1); s--) {
                    System.out.print(matrix[s][sc] + " ");
                }
            }
            sr++ ;
            sc++ ;
            er-- ;
            ec-- ;
        }
    }

    /*
    * Question 3 :-
    * WAF to calculate diagonal sum of a given matrix
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int diagonalSum(int[][] matrix) {
        int sum = 0 ;
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i] ;
            if(i != (matrix.length-1-i)) {
                sum += matrix[i][matrix.length-1-i] ;
            }
        }
        return sum ;
    }

    /*
    * Question 4 :-
    * Search in sorted array problem
    * Time Complexity :- O(m+n), Space Complexity :- O(1)*/
    public static boolean staircaseSearch(int[][] matrix, int key) {
        int row = 0 ;
        int col = matrix[0].length-1 ;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
                return true ;
            } else if(key < matrix[row][col]) {
                col-- ;
            } else {
                row++ ;
            }
        }
        return false ;
    }

    /*
    * Question 5 :-
    * WAF to print matrix in column wise
    * Time Complexity :- O(m*n), Space Complexity :- O(1)*/
    public static void print_matrix_columnWise(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + " ") ;
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    * Question 6 :-
    * WAF to reverse every row of a matrix
    * Time Complexity :- O(n*m), Space Complexity :- O(1)*/
    public static void reverseRow(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int si = 0 ;
            int ei = matrix[i].length-1 ;
            while(si < ei) {
                int temp = matrix[i][si] ;
                matrix[i][si] = matrix[i][ei] ;
                matrix[i][ei] = temp ;
                si++ ;
                ei-- ;
            }
        }
    }

    // main function
    public static void main(String[] args) {

        /* 2D Arrays */

        // Test Case for Question 6 :-
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}} ;
//        reverseRow(matrix);
//        for(int[] arr : matrix) {
//            for(int ele : arr) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }

        // Test Case for Question 5 :-
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}} ;
//        print_matrix_columnWise(matrix);
//        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}} ;
//        print_matrix_columnWise(matrix1);

        // Test Case for Question 4 :-
//        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}} ;
//        System.out.println(staircaseSearch(matrix, 33));

        // Test Case for Question 3 :-
//        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}} ;
//        System.out.println(diagonalSum(matrix1));
//        int[][] matrix2 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}} ;
//        System.out.println(diagonalSum(matrix2));

        // Test Case for Question 2 :-
//        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}} ;
//        spiralMatrix(matrix1);
//        int[][] matrix2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}} ;
//        spiralMatrix(matrix2);
//        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} ;
//        spiralMatrix(matrix3);

        // Test Case for Question 1 :-
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7}, {8, 9, 10}} ;
//        int key = 7 ;
//        linearSearch_2D_matrices(matrix, key);

        /* 1D Arrays*/
        // Test Case for Question 13 :-
//        int[] prices = {7, 1, 5, 3, 6, 4} ;
//        System.out.println(stockBuyAndSell(prices));

        // Test Case for Question 12 :-
//        int[] heights = {4, 2, 0, 6, 3, 2, 5} ;
//        System.out.println(trappingRainWater(heights));

        // Test Case for Question 11 :-
        int[] arr = {7, 3, 9, 1} ;
        int d = 9 ;
        System.out.println("Array before rotation :- ");
        printArr(arr);
        rotateArr(arr, d);
        System.out.println("\nArray after rotation :- ");
        printArr(arr);

        // Test Case for Questin 10 :-
//        int[] arr = {1, -2, 6, -1, 3} ;
//        System.out.println(max_sumArray_sum_kadane(arr));

        // Test Case for Question 9 :-
//        int[] arr = {1, -2, 6, -1, 3} ;
//        System.out.println(max_sumArray_sum_prefixArray(arr));

        // Test Case for Question 8 :-
//        int[] arr = {1, -2, 6, -1, 3} ;
//        System.out.println(max_subArray_sum_bruteforce(arr));

        // Test Case for Question 7 :-
//        int[] arr = {2, 4, 6, 8, 10} ;
//        printSubarray(arr);

        // Test Case for Question 6 :-
//        int[] arr = {2, 4, 6, 8, 10} ;
//        printPairs(arr);

        // Test Case for Question 5 :-
//        int[] arr = {234, 876, -76432, -43, 0, 876, 752, 658, 832, -436, -612, -723} ;
//        reverseArr(arr);
//        printArr(arr);


        // Test Case for Question 4 :-
//        int[] arr = {2, 4, 6, 8, 10, 12, 14} ;
//        int target = 10 ;
//        System.out.println(binarySearch(arr, target));

        // Test Case for Question 3 :-
//        int[] arr = {234, 876, -76432, -43, 0, 876, 752, 658, 832, -436, -612, -723} ;
//        System.out.println(smallestElement(arr));

        // Test Case for Question 2 :-
//        int[] arr = {234, 876, -76432, -43, 0, 876, 752, 658, 832, -436, -612, -723} ;
//        System.out.println(largestElement(arr));

        // Test Case for Question 1 :-
//        int[] arr = {234, 876, -76432, -43, 0, 876, 752, 658, 832, -436, -612, -723} ;
//        int target1 = 987 ;
//        int target2 = -436 ;
//        System.out.println(linearSearch(arr, target1));
//        System.out.println(linearSearch(arr, target2));
    }
}
