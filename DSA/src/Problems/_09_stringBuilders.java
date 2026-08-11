package Problems;

import static Concept._06_arrays.printArr;

public class _09_stringBuilders {

    /*
    * Problem 1 :-
    * Anagram
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static boolean isAnagram(String str1, String str2) {
        int m = str1.length() ;
        int n = str2.length() ;

        if(m != n) {
            return false ;
        }

        int[] freqArr = new int[26] ;
        printArr(freqArr) ;
        for(int i = 0; i < m; i++) {
            int idx1 = str1.charAt(i) - 'a' ;
            freqArr[idx1]++ ;

            int idx2 = str2.charAt(i) - 'a' ;
            freqArr[idx2]-- ;
        }

        printArr(freqArr);
        for(int i = 0; i < freqArr.length; i++) {
            if(freqArr[i] != 0) {
                return false ;
            }
        }

        return true ;
    }

    /*
    * Problem 2 :-
    * Most frequent character (lexi*/

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 1 :-
        String str1 = "race" ;
        String str2 = "acer" ;
        System.out.println(isAnagram(str1, str2));
    }
}
