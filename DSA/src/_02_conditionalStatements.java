import java.util.Scanner;

public class _02_conditionalStatements {

    // main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        // conditional statements
//        System.out.print("Enter your age :- ");
//        int age = sc.nextInt() ;
//        if((age < 0) || (age > 130)) {
//            System.out.println("Invalid age");
//        } else if((age >= 18) && (age <= 90)) {
//            System.out.println("You can vote");
//        } else if(age < 18) {
//            System.out.println("You have to wait for " + (18-age) + " to vote");
//        } else {
//            System.out.println("You are too old, now rest don't choose leaders");
//        }

        // ternary operator
//        String str = (age>18) ? "Adult" : "Child" ;
//        System.out.println(str);
//
//        boolean isAdult = (age>18) ? true : false ;
//        System.out.println(isAdult);

        // switch statement
        System.out.print("Enter first operand :- ");
        int operand_1 = sc.nextInt() ;
        System.out.print("Enter second operand :- ");
        int operand_2 = sc.nextInt() ;
        System.out.print("Enter operator :- ");
        char operator = sc.next().charAt(0) ;

        switch(operator) {
            case '+' :
                System.out.println("Sum of " + operand_1 + " and " + operand_2 + " = " + (operand_1+operand_2));
                break ;
            case '-' :
                System.out.println("Diff of " + operand_1 + " and " + operand_2 + " = " + (operand_1-operand_2));
                break ;
            case '*' :
                System.out.println("Product of " + operand_1 + " and " + operand_2 + " = " + (operand_1*operand_2));
                break ;
            case '/' :
                System.out.println("Division of " + operand_1 + " and " + operand_2 + " = " + (operand_1/operand_2));
                break ;
            default:
                System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
