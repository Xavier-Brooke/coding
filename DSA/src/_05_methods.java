public class _05_methods {

    /*
    * Problem 1 :-
    * WAF to convert a binary number to decimal number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int binaryToDecimal(int num) {
        int decimal = 0 ;
        int pow = 1 ;
        while(num > 0) {
            decimal += (num%10 * pow) ;
            pow *= 2 ;
            num /= 10 ;
        }

        return decimal ;
    }

    /*
    * Problem 2 :-
    * WAF to convert decimal number to binary number
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static int decimalToBinary(int num) {
        int binary = 0 ;
        int pow = 1 ;
        while(num > 0) {
            binary += (num%2 * pow) ;
            pow *= 10 ;
            num /= 2 ;
        }

        return binary ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
//        int deci1 = 10 ;
//        System.out.println(decimalToBinary(deci1));
//        int deci2 = 5 ;
//        System.out.println(decimalToBinary(deci2));
//        int deci3 = 7 ;
//        System.out.println(decimalToBinary(deci3));
//        int deci4 = 16 ;
//        System.out.println(decimalToBinary(deci4));

        // Test Case for Problem 1 :-
//        int binary1 = 101 ;
//        System.out.println(binaryToDecimal(binary1));
//        int binary2 = 111 ;
//        System.out.println(binaryToDecimal(binary2));
//        int binary3 = 10000 ;
//        System.out.println(binaryToDecimal(binary3));
    }
}
