public class _05_methods {

    /*
    * Problem 1 :-
    * WAF to print the prime numbers in given range
    * Time Complexity :- O(n * sqrt(end)), Space Complexity :- O(1)*/
    public static void primeRange(int start, int end) {
        for(int i = start; i <= end; i++) {
            boolean isPrime = true ;
            for(int j = 2; j <= (int)(Math.sqrt(i)); j++) {
                if(i%j == 0) {
                    isPrime = false ;
                    break ;
                }
            }
            if(isPrime) System.out.print(i + ", ");
        }
    }

    /*
    * Problem 2 :-
    * WAF to convert a decimal number to binary number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int decimalToBinary(int deci) {
        int binary = 0 ;
        int pow = 0 ;
        while(deci != 0) {
            int rem = deci%2 ;
            binary += (rem * (int)(Math.pow(10, pow))) ;
            pow++ ;
            deci /= 2 ;
        }
        return binary ;
    }

    /*
    * Problem 3 :-
    * WAF to convert a binary number to decimal number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int binaryToDecimal(int binary) {
        int decimal = 0 ;
        int pow = 0 ;
        while(binary != 0) {
            int rem = binary%10 ;
            decimal += (rem * (int)(Math.pow(2, pow)));
            pow++ ;
            binary /= 10 ;
        }
        return decimal ;
    }

    // main function
    static public void main(String[] args) {

        // Test Case for Problem 3 :-
        System.out.println(binaryToDecimal(111));

        // Test Case for Problem 2 :-
//        System.out.println(decimalToBinary(8));

        // Test Case for Problem 1 :-
//        primeRange(2, 10);
    }
}
