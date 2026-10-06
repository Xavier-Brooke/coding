public class _04_patternPrinting {

    /*
    * Problem 1 :-
    * WAF to print the given pattern
     * * * * *
     *       *
     *       *
     * * * * *
     * Time Complexity :- O(n^2), Space Complexity :- O(1)*/
    public static void hollowRectangle(int rows, int cols) {
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(i == 1 || j == 1 || i == rows || j == cols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /*
    * Problem 2 :-
    * WAF to print given patter
    *   11111
        12221
        12321
        12221
        11111

    * Time Complexity :- O(n^2), Space Complexity :- O(n)*/
    public static void uniqueSquarePattern(int rows) {
        int n = (2 * rows) ;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                int p = i, q = j;
                if(i > rows) p = n-i ;
                if(j > rows) q = n-j ;
                System.out.print(Math.min(p, q));
            }
            System.out.println();
        }
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
        uniqueSquarePattern(3);

        // Test Case for Problem 1 :-
//        hollowRectangle(4, 5);
    }
}
