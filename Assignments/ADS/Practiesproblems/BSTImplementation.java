package Practiesproblems;


public class BSTImplementation {

    // =========================================================
    // NODE
    // =========================================================
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

    Node root = null;

    // =========================================================
    // 1. INSERTION
    // =========================================================
    Node insert(Node root, int data) {

        // If tree/subtree is empty,
        // new node becomes the root
        if (root == null) {
            return new Node(data);
        }

        // Smaller values go to left subtree
        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        // Greater values go to right subtree
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        // Duplicate value is ignored
        else {
            System.out.println("Duplicate value: " + data);
        }

        return root;
    }

    // =========================================================
    // 2. SEARCH
    // =========================================================
    boolean search(Node root, int key) {

        // Value not found
        if (root == null) {
            return false;
        }

        // Value found
        if (root.data == key) {
            return true;
        }

        // Search left
        if (key < root.data) {
            return search(root.left, key);
        }

        // Search right
        return search(root.right, key);
    }

    // =========================================================
    // 3. DELETE
    // =========================================================
    Node delete(Node root, int key) {

        // Value not found
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (key < root.data) {
            root.left = delete(root.left, key);
        }

        // Search in right subtree
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }

        // Node found
        else {

            // CASE 1: No child (Leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // CASE 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // CASE 2: Only left child
            if (root.right == null) {
                return root.left;
            }

            // CASE 3: Two children
            // Find inorder successor
            Node successor = findMin(root.right);

            // Copy successor's value
            root.data = successor.data;

            // Delete successor from right subtree
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // =========================================================
    // FIND MINIMUM VALUE
    // =========================================================
    Node findMin(Node root) {

        Node temp = root;

        // Leftmost node contains minimum value
        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    // =========================================================
    // 4. INORDER TRAVERSAL
    // Left -> Root -> Right
    // =========================================================
    void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // =========================================================
    // 5. PREORDER TRAVERSAL
    // Root -> Left -> Right
    // =========================================================
    void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
    }

    // =========================================================
    // 6. POSTORDER TRAVERSAL
    // Left -> Right -> Root
    // =========================================================
    void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);

        postorder(root.right);

        System.out.print(root.data + " ");
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        BSTImplementation tree = new BSTImplementation();

        // Insert values
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        /*
                    50
                   /  \
                 30    70
                /  \   / \
              20   40 60  80
        */

        // Inorder
        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        // Preorder
        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        // Postorder
        System.out.print("Postorder: ");
        tree.postorder(tree.root);
        System.out.println();

        // Search
        int key = 40;

        if (tree.search(tree.root, key)) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }

        // Delete leaf node
        tree.root = tree.delete(tree.root, 20);

        System.out.print("After deleting 20: ");
        tree.inorder(tree.root);
        System.out.println();

        // Delete node with one child
        tree.root = tree.delete(tree.root, 30);

        System.out.print("After deleting 30: ");
        tree.inorder(tree.root);
        System.out.println();

        // Delete node with two children
        tree.root = tree.delete(tree.root, 50);

        System.out.print("After deleting 50: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}