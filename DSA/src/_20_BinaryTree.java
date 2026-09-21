public class _20_BinaryTree {

    static class Node {
        int val ;
        Node left ;
        Node right ;
        Node(int val) {
            this.val = val ;
        }
    }

    public static void display(Node root) {
        if(root == null) {
            return ;
        }

        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static int getSize(Node root) {
        if(root == null) {
            return 0 ;
        }

        return (1 + getSize(root.left) + getSize(root.right)) ;
    }

    public static int sum(Node root) {
        if(root == null) {
            return 0 ;
        }

        return (root.val + sum(root.left) + sum(root.right)) ;
    }

    public static int product(Node root) {
        if(root == null) {
            return 1 ;
        }

        return (root.val * product(root.right) * product(root.left)) ;
    }

    public static int product_2(Node root) {
        if(root == null || (root.val == 0)) {
            return 1 ;
        }

        return (root.val * product_2(root.left) * product_2(root.right)) ;
    }

    private static int maximum(Node root) {
        if(root == null) {
            return Integer.MIN_VALUE ;
        }

        return (Math.max(root.val, (Math.max(maximum(root.left), maximum(root.right))))) ;
    }

    // main function
    public static void main(String[] args) {

        Node a = new Node(2) ;
        Node b = new Node(3) ;
        Node c = new Node(1) ;
        Node d = new Node(4) ;
        Node e = new Node(0) ;
        Node f = new Node(1) ;
        Node g = new Node(9) ;
        a.left = b ; a.right = c ;
        b.left = d ; b.right = e ;
        c.left = f ; c.right = g ;

        display(a) ;
        System.out.println();
        System.out.println("Maximum element :- " + maximum(a));
//        System.out.println();
//        System.out.println(getSize(a));
//        System.out.println("\nSum of Nodes = " + sum(a));
//        System.out.println("\nProduct := " + product(a));
//        System.out.println("Product 2 :- " + product_2(a));
    }
}