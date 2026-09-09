import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Collections;

public class _07_ArrayList {

    /*
    * Problem 1 :-
    * Reverse ArrayList
    * Time Complexity :- O(n), Space Complexity :- O(1)*/
    public static void reverse(ArrayList<Integer> list) {
        int j = list.size()-1 ;
        int i = 0 ;
        while(i < j) {
            int temp = list.get(i) ;
            list.set(i, list.get(j)) ;
            list.set(j, temp) ;
            i++ ;
            j-- ;
        }
    }

    /*
    * Problem 2 :-
    * Container with Most Water
    * Time Complexity :- O(n), Space Complexity :- O()*/
    public static int max_container_capacity(ArrayList<Integer> heights) {

        int maxCapacity = 0 ;

        int i = 0 ;
        int j = heights.size()-1 ;
        int tempCapacity ;
        int waterLevel ;
        while(i < j) {
            int leftHeight = heights.get(i) ;
            int rightHeight = heights.get(j) ;
            waterLevel = Math.min(leftHeight, rightHeight) ;
            tempCapacity = (j - i) * waterLevel ;
            maxCapacity = Math.max(maxCapacity, tempCapacity) ;
            if(leftHeight <= rightHeight) {
                i++ ;
            } else {
                j-- ;
            }
        }
        return maxCapacity ;
    }

    // main function
    public static void main(String[] args) {

        // Test Case for Problem 2 :-
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)) ;
        System.out.println(max_container_capacity(height));

        // Test Case for Problem 1 :-
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10)) ;
//        System.out.println("ArrayList before reverse :- " + list);
//        reverse(list);
//        System.out.println("ArrayList after reverse :- " + list);
    }
}
