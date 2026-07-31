package Problems;

public class _11_recursion {

    /*
    * Problem 1 :-
    * WAF to print the reverse of a number
    * Time Complexity :- O(), Space Complexity :- O()*/
    public static void reverseNumber(int n, int x) {
        if(n == 0) {
            System.out.println(x);
            return ;
        }

        reverseNumber(n/10, ((x*10) + (n%10)));
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 1 :-
        reverseNumber(12345, 0);
    }
}
