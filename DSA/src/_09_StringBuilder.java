import java.util.Arrays ;

public class _09_StringBuilder {

    /*
    * Problem 1 :-
    * For a given String convert each the first letter of each word to uppercase.
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static StringBuilder capitalize(String str) {
        StringBuilder sb = new StringBuilder() ;

        int i = 0 ;
        sb.append(Character.toUpperCase(str.charAt(i++))) ;

        while(i < str.length()) {
            if(str.charAt(i-1) == ' ') {
                char ch = Character.toUpperCase(str.charAt(i++)) ;
                sb.append(ch) ;
            }
            sb.append(str.charAt(i)) ;
            i++ ;
        }

        return sb ;
    }

    /*
    * Problem 2 :-
    * String Compression
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static StringBuilder compress(String str) {

        StringBuilder sb = new StringBuilder() ;

        int i = 0 ;
        while(i < (str.length())) {
            Integer count = 0 ;
            char ch = str.charAt(i) ;
            while((i < str.length()) && (str.charAt(i) == ch)) {
                count++ ;
                i++ ;
            }
            sb.append(ch) ;
            if(count > 1) {
                sb.append(count.toString()) ;
            }
        }

        return sb ;
    }

    /*
    * Problem 3 :-
    * Most frequent character
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static char getMostOccurringChar(String str) {
        int[] freq = new int[26] ;
        str = str.toLowerCase() ;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i) ;
            if(ch >= 'a' && ch <= 'z') {
                int idx = str.charAt(i) - 'a' ;
                freq[idx]++ ;
            }
        }

        int max = Integer.MIN_VALUE ;
        char ans = '\0' ;
        for(int i = 0; i < freq.length; i++) {
            int tempMax = freq[i] ;
            if(tempMax > max) {
                max = tempMax ;
                ans = (char)('a'+i) ;
            }
        }

        return ans ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 3 :-
        String str = "this is sample string. a a is a a a ia " ;
        System.out.println(getMostOccurringChar(str)); ;

        // Test Case for Problem 2 :-
//        String str = "aaaaaaaaaaaabbbbbbbbbbbbccccccccccccddddddddddddddddefghiiiiiiiiiiiijjjjjjjjjjjjjjjkkkkkkkkkklmnooooooooooopqrrrrrrrrrrrstuvvvvvvvvvwxyzzzzzzzzzzzz" ;
//        System.out.println(compress(str));

        // Test Case for Problem 1 :-
//        String str = "hi, i am xavier brooke" ;
//        System.out.println(capitalize(str));
    }
}
