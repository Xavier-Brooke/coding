public class _20_BinaryTree {

    // Node class
    static class Node {
        int val ;
        Node left, right ;
        Node(int val) {
            this.val = val ;
        }
    }

    // displaying the tree
    public static void display(Node root) {
        display_helper(root) ;
        System.out.println();
    }

    public static void display_helper(Node root) {
        if(root == null)
            return ;
        System.out.print(root.val + " ");
        display_helper(root.left);
        display_helper(root.right);
    }

    // size of binaryTree
    public static int size(Node root) {
        if(root == null)
            return 0 ;
        return (1 + size(root.left) + size(root.right)) ;
    }

    // sum of values of Nodes of a BinaryTree
    public static int sum(Node root) {
        if(root == null)
            return 0 ;
        return (root.val + sum(root.left) + sum(root.right)) ;
    }

    // product of all non-zero values of Nodes of a BinaryTree
    public static int product(Node root) {
        if(root == null)
            return 1 ;

        int leftProduct = product(root.left) ;
        int rightProduct = product(root.right) ;
        if(root.val == 0)
            return  leftProduct * rightProduct ;

        return (root.val * leftProduct * rightProduct) ;
    }

    // maximum value in BinaryTree
    public static int maximum(Node root) {
        if(root == null)
            return Integer.MIN_VALUE ;
        return Math.max(root.val, Math.max(maximum(root.left), maximum(root.right))) ;
    }

    // levels
    public static int level(Node root) {
        if(root == null)
            return 0 ;
        return (1 + Math.max(level(root.left), level(root.right))) ;
    }

    // preorder
    public static void preorder(Node root) {
        if(root == null)
            return ;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // inorder
    public static void inorder(Node root) {
        if(root == null)
            return ;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // postorder
    public static void postorder(Node root) {
        if(root == null)
            return ;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // basic details of binaryTree
    public static void details(Node root) {
        System.out.println("-".repeat(100));
        System.out.println("Size of BinaryTree :- " + size(root));
        System.out.println("Sum of every Nodes of BinaryTree :- " + sum(root));
        System.out.println("Product of every non-zero Nodes of BinaryTree :- " + product(root));
        System.out.println("Maximum Value of a Node in BinaryTree :- " + maximum(root));
        System.out.println("Level of BinaryTree :- " + level(root));
        System.out.println("-".repeat(100));
    }

    // main function
    public static void main(String[] args) {

        // creating Nodes
        Node a = new Node(1) ;
        Node b = new Node(2) ;
        Node c = new Node(3) ;
        Node d = new Node(4) ;
        Node e = new Node(5) ;
        Node f = new Node(6) ;
        Node g = new Node(7) ;

        // connecting Nodes
        a.left = b ; a.right = c ;
        b.left = d ; b.right = e ;
        c.left = f ; c.right = g ;

        // display
        display(a);

        // details
//        details(a);

        // preorder
//        preorder(a);
//        System.out.println();

        // inorder
//        inorder(a);
//        System.out.println();

        // postorder
//        postorder(a);
//        System.out.println();

        // level
//        System.out.println(level(a));

        // maximum
//        System.out.println("Maximum Value in BinaryTree :- " + maximum(a));

        // product
//        System.out.println(product(a));

        // sum
//        System.out.println(sum(a));

        // size
//        System.out.println(size(a));
    }
}
