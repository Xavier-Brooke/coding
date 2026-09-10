public class _08_Strings {

    /*
    * Problem 1 :-
    * Function for substring
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static String substring(String str, int i, int j) {
        String ans = "";
        while(i < j) {
            ans += str.charAt(i) ;
            i++ ;
        }
        return ans ;
    }

    /*
    * Problem 2 :-
    * For a given set of Strings, print the largest string.
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void largestString(String[] strArr) {
        String largest = strArr[0] ;
        String tempLargest = "" ;
        for(int i = 1; i < strArr.length; i++) {
            tempLargest = strArr[i] ;
            int res = largest.compareToIgnoreCase(tempLargest) ;
            if(res < 0) {
                largest = tempLargest ;
            }
        }

        System.out.println("Largest String in the given Array is '" + largest + "'");
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
        String[] strArr = { "Apple", "Banana", "Mango"} ;
        largestString(strArr);

        // Test Case for Problem 1 :-
//        String str = "This is sample string" ;
//        System.out.println(substring(str, 3, str.length()-3));
    }
}
