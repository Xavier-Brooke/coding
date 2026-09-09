public class _06_Arrays {

    /*
    * Problem 1 :-
    * Max subarray sum (Prefix sum)
    * Time Complexity :- O(n^2), Space Complexity :- O(n)*/
    public static int maxSubArraySum_PrefixArray(int[] arr) {
        int n = arr.length ;
        int[] prefixSum = new int[n] ;
        prefixSum[0] = arr[0] ;
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i] ;
        }

        int maxSum = Integer.MIN_VALUE ;
        int tempSum ;
        for(int i = 0; i < n; i++) {
            tempSum = 0 ;
            for(int j = i; j < n; j++) {
                tempSum = (i == 0) ? prefixSum[j] : (prefixSum[j] - prefixSum[i-1]) ;
                maxSum = Math.max(maxSum, tempSum) ;
            }
        }

        return maxSum ;
    }

    /*
    * Problem 2 :-
    * Max subarray sum (Kadane's Algorithm)
    * Time Complexity :- O(n), Space Complexity :- O(1)
    * Note :- Kadane's Algorithm doesn't work for negative maxSum*/
    public static int maxSubArraySum_KadaneAlgorithm(int[] arr) {
        int maxSum = Integer.MIN_VALUE ;
        int currSum = 0 ;
        for (int j : arr) {
            currSum += j;
            if (currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum ;
    }

    /*
    * Problem 3 :-
    * Trapping Rainwater
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static int trappingRainwater(int[] heights) {
        int n = heights.length ;

        int[] leftMax = new int[n] ;
        leftMax[0] = heights[0] ;
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]) ;
        }

        int[] rightMax = new int[n] ;
        rightMax[n-1] = heights[n-1] ;
        for(int i = (n-2); i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], heights[i]) ;
        }

        int trappedWater = 0 ;
        int barWidth = 1 ;
        int waterLevel ;
        for(int i = 0; i < n; i++) {
            waterLevel = Math.min(leftMax[i], rightMax[i]) ;
            trappedWater += (waterLevel - heights[i]) * barWidth ;
        }

        return trappedWater ;
    }

    /*
    * Problem 4 :-
    * Buy & Sell Stocks
    * Time Complexity :- O(n), Space Compelxity :- O(1)*/
    public static int maxProfit(int[] price) {
        int maxProfit = 0 ;
        int buyingPrice = price[0] ;
        for(int i = 1; i < price.length; i++) {
            int currProfit = 0 ;
            if(buyingPrice < price[i]) {
                currProfit = price[i] - buyingPrice ;
            } else {
                buyingPrice = price[i] ;
            }
            maxProfit = Math.max(maxProfit, currProfit) ;
        }

        return maxProfit ;
    }

    /*
    * Problem 5 :-
    * Merge two sorted Arrays
    * Time Complexity :- O(Max(m, n)), Space Complexity :- O(m+n)*/
    public static int[] merge(int[] a, int[] b) {
        int m = a.length ;
        int n = b.length ;
        int[] mergedArray = new int[m+n] ;

        int i,j,k ;
        i = j = k = 0 ;
        while((i < m) || (j < n)) {
            if((i < m) && (i < n)) {
                if(a[i] <= b[j]) {
                    mergedArray[k] = a[i] ;
                    i++ ;
                } else {
                    mergedArray[k] = b[j] ;
                    j++ ;
                }
            } else {
                if(i < m) {
                    mergedArray[k] = a[i] ;
                    i++ ;
                } else {
                    mergedArray[k] = b[j] ;
                    j++ ;
                }
            }
            k++ ;
        }

        return mergedArray ;
    }

    /*
    * Problem 6 :-
    * Spiral Matrix
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void printSpiralMatrix(int[][] matrix) {
        int sr = 0 ;
        int sc = 0 ;
        int er = matrix.length-1 ;
        int ec = matrix[0].length-1 ;

        while((sr <= er) && (sc <= ec)) {
            for(int j = sc; j <= ec; j++) {
                System.out.print(matrix[sr][j] + " ") ;
            }
            sr++ ;

            for(int i = sr; i <= er; i++) {
                System.out.print(matrix[i][ec] + " ");
            }
            ec-- ;

            if(sr <= er) {
                for(int j = ec; j >= sc; j--) {
                    System.out.print(matrix[er][j] + " ");
                }
                er-- ;
            }

            if(sc <= ec) {
                for(int i = er; i >= sr; i--) {
                    System.out.print(matrix[i][sc] + " ");
                }
                sc++ ;
            }
        }
    }

    /*
    * Problem 7 :-
    * Search in Sorted Matrix
    * Time Complexity :- O(m+n), Space Complexity :- O(1)*/
    public static boolean search_in_sorted_matrix(int[][] matrix, int key) {
        int rows = 0 ;
        int cols = matrix[0].length-1 ;
        while((rows < matrix.length) && (cols >= 0)) {
            if(key == matrix[rows][cols]) {
                System.out.println("(" + rows + ", " + cols + ")");
                return true ;
            } else if(key < matrix[rows][cols]) {
                 cols-- ;
            } else {
                rows++ ;
            }
        }

        return false ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 7 :-
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}} ;
        int key = 33234 ;
        System.out.println(search_in_sorted_matrix(matrix, key));

        // Test Case for Problem 6 :-
//        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}} ;
//        printSpiralMatrix(matrix1);
//        int[][] matrix2 = {{1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12}} ;
//        System.out.println();
//        printSpiralMatrix(matrix2);

        // Test Case for Problem 5 :-
//        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10} ;
//        int[] b = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20} ;
//        int[] c = merge(a, b) ;
//        for(int ele : c) {
//            System.out.print(ele + ",");
//        }

        // Test Case for Problem 4 :-
//        int[] price = {7, 1, 5, 3, 6, 4} ;
//        System.out.println(maxProfit(price));

        // Test Case for Problem 3 :-
//        int[] heights = {4, 2, 0, 6, 3, 2, 5} ;
//        System.out.println(trappingRainwater(heights));

        // Test Case for Problem 2 :-
//        int[] arr1 = {1, -2, 6, -1, 3} ;
//        System.out.println(maxSubArraySum_KadaneAlgorithm(arr1));
//        int[] arr2 = {-23, -8, -45, -1, -13} ;
//        System.out.println(maxSubArraySum_KadaneAlgorithm(arr2));

        // Test Case for Problem 1 :-
//        int[] arr1 = {1, -2, 6, -1, 3} ;
//        System.out.println(maxSubArraySum_PrefixArray(arr1));
//        int[] arr2 = {-23, -8, -45, -1, -13} ;
//        System.out.println(maxSubArraySum_PrefixArray(arr2));
    }
}
