public class _10_sortingAlgorithms {

    /*
    * Problem 1 :-
    * Bubble Sort
    * Time Complexity :- O(n^2), Space Complexity :- O(n^2)*/
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < (n-1); i++) {
            for(int j = 0; j < (n-1-i); j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j+1] ;
                    nums[j+1] = nums[j] ;
                    nums[j] = temp ;
                }
            }
        }
    }

    /*
    * Problem 2 :-
    * Selection Sort
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void selectionSort(int[] nums) {
        int n = nums.length ;
        for(int i = 0; i < n-1; i++) {
            int minIdx = i ;
            for(int j = (i+1); j < n; j++) {
                if(nums[minIdx] > nums[j]) {
                    minIdx = j ;
                }
            }

            int temp = nums[minIdx] ;
            nums[minIdx] = nums[i] ;
            nums[i] = temp ;
        }
    }

    public static void selectionSort_2(int[] nums) {
        int n = nums.length ;
        for(int i = (n-1); i > 0; i--) {
            int maxIdx = i ;
            for(int j = i; j >= 0; j--) {
                if(nums[maxIdx] < nums[j]) {
                    maxIdx = j ;
                }
            }

            int temp = nums[maxIdx] ;
            nums[maxIdx] = nums[i] ;
            nums[i] = temp ;
        }
    }

    /*
    * Problem 3 :-
    * Insertion Sort
    * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void insertionSort(int[] nums) {
        int n = nums.length ;
        for(int i = 1; i < n; i++) {
            int curr = nums[i] ;
            int prev = i-1 ;
            while((prev >= 0) && (curr < nums[prev])) {
                nums[prev+1] = nums[prev] ;
                prev-- ;
            }

            nums[++prev] = curr ;
        }
    }

    // print Array
    public static void print(int[] arr) {
        for(int ele : arr) {
            System.out.print(ele + ", ");
        }
        System.out.println();
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 3 :-
        int[] nums = {-2, 34, 0, 4347, -87, -234, 23487, 168, -87, 43, -676, 88} ;
        insertionSort(nums);
        print(nums);

        // Test Case for Problem 2 :-
//        int[] nums = {-2, 34, 0, 4347, -87, -234, 23487, 168, -87, 43, -676, 88} ;
//        selectionSort(nums);
//        print(nums);
//        int[] nums = {-2, 34, 0, 4347, -87, -234, 23487, 168, -87, 43, -676, 88} ;
//        selectionSort_2(nums);
//        print(nums);

        // Test Case for Problem 1 :-
//        int[] nums = {-2, 34, 0, 4347, -87, -234, 23487, 168, -87, 43, -676, 88} ;
//        bubbleSort(nums);
//        print(nums);
    }
}
