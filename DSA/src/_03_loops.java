public class _03_loops {

    /*
    * Problem 1 :-
    * WAF to reverse a number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int reverse(int num) {
        int ans = 0 ;
        while(num != 0) {
            int rem = num%10 ;
            ans = (ans*10) + rem ;
            num /= 10 ;
        }
        return ans ;
    }

    /*
    * Problem 2 :-
    * WAF to check if a given number is prime or composite
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false ;
        }
        for(int i = 2; i <= (int)(Math.sqrt(num)); i++) {
            if(num%i == 0) {
                return false ;
            }
        }
        return true ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
        int num = 23 ;
        System.out.println(isPrime(num));

        // Test Case for Problem 1 :-
//        int num = 123456 ;
//        System.out.println(reverse(num));
    }
}
