public class BSTpractice {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root,int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.data) {
            root.left = buildBST(root.left, val);
        }
        else {
            root.right = buildBST(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printInRange(Node root, int x, int y) {
        if(root == null) {
            return;
        }
        if(x <= root.data && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
    }
    public static void main(String args[]) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }
        inorder(root);
        System.out.println();

        printInRange(root, 3, 12);
        System.out.println();
    }
}