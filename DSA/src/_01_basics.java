import java.util.Scanner ;

public class _01_basics {

    // main function
    public static void main(String[] args) {

        // taking input
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter your name :- ");
        String name = sc.nextLine() ;
        System.out.println("Hello, " + name);
        sc.close();
    }
}
