package Concept;

public class _09_stringBuilders {

    /*
    * Question 1 :-
    * WAF to convert each word's first letter to capital
    * Time Complexity :- O(n), Space Complexity :- O(n)*/
    public static StringBuilder capitalize(String str) {
        StringBuilder ans = new StringBuilder() ;
        char prevChar = Character.toUpperCase(str.charAt(0)) ;
        ans.append(prevChar) ;

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i-1) == ' ') {
                ans.append(Character.toUpperCase(str.charAt(i))) ;
            } else {
                ans.append(str.charAt(i)) ;
            }
        }

        return ans ;
    }

    /*
    * Question 2 :-
    * String Compression
    * Time Complexity :- O(n^2), Space Complexity :- O(n)*/
    public static StringBuilder stringCompression(String str) {
        StringBuilder ans = new StringBuilder() ;
        for(int i = 0; i < str.length(); i++) {
            int freq = 0 ;
            int j = (i+1) ;
            while(j < str.length()) {
                if((str.charAt(i) == str.charAt(j))) {
                    freq++ ;
                }
                j++ ;
            }
            ans.append(str.charAt(i)) ;
            ans.append(freq) ;
        }
        return ans ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Question 1 :-
        String str = "hi, i am xavier brooke" ;
        System.out.println(capitalize(str)) ;

        // Basics
//        StringBuilder sb = new StringBuilder() ;
//        String str = "" ;
//        for(char ch = 'a'; ch <= 'z'; ch++) {
//            sb.append(ch) ;
//            str += ch ;
//        }
//        sb.append(str.toUpperCase()) ;
//        System.out.println(sb);
    }
}
