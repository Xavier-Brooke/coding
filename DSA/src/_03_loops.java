public class _03_loops {

    /*
    * Problem 1 :-
    * WAF to Reverse a number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int reverseNum(int num) {
        int reverse = 0 ;
        while(num != 0) {
            reverse = (reverse*10) + (num%10) ;
            num /= 10 ;
        }
        return reverse ;
    }

    /*
    * Problem 2 :-
    * WAF to Check if a given number is prime or composite
    * Time Complexity :- O(√n), Space Complexity :- O(1)*/
    public static String prime_composite(int num) {
        if(num <= 1) {
            return "Neither Prime nor Composite" ;
        }
        for(int i = 2; i <= (int)(Math.sqrt(num)); i++) {
            if(num%i == 0) {
                return "Composite" ;
            }
        }

        return "Prime" ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
//        int num1 = 9873 ;
//        System.out.println(prime_composite(num1));
//        int num2 = -43987 ;
//        System.out.println(prime_composite(num2));
//        int num3 = 131313 ;
//        System.out.println(prime_composite(num3));
//        int num4 = 7 ;
//        System.out.println(prime_composite(num4));

        // Test Case for Problem 1 :-
//        int num1 = 98734 ;
//        System.out.println(reverseNum(num1));
//        int num2 = 340000 ;
//        System.out.println(reverseNum(num2));
//        int num3 = -234 ;
//        System.out.println(reverseNum(num3));
//        int num4 = -2344 ;
//        System.out.println(reverseNum(num4));
    }
}
