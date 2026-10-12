package Practiesproblems;

public class AVLTreeImplementation {

    // =========================================================
    // NODE
    // =========================================================
    static class Node {

        int data;
        int height;

        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;   // New node is initially a leaf
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    // =========================================================
    // GET HEIGHT
    // =========================================================
    int height(Node node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // =========================================================
    // GET BALANCE FACTOR
    // =========================================================
    int getBalance(Node node) {

        if (node == null) {
            return 0;
        }

        // Balance Factor =
        // height of left subtree - height of right subtree
        return height(node.left) - height(node.right);
    }

    // =========================================================
    // UPDATE HEIGHT
    // =========================================================
    void updateHeight(Node node) {

        node.height = 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }

    // =========================================================
    // RIGHT ROTATION
    // Used mainly for LL case
    // =========================================================
    Node rightRotate(Node y) {

        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // x becomes new root of this subtree
        return x;
    }

    // =========================================================
    // LEFT ROTATION
    // Used mainly for RR case
    // =========================================================
    Node leftRotate(Node x) {

        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // y becomes new root of this subtree
        return y;
    }

    // =========================================================
    // INSERTION
    // =========================================================
    Node insert(Node root, int data) {

        // Normal BST insertion
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {

            root.left = insert(root.left, data);

        } else if (data > root.data) {

            root.right = insert(root.right, data);

        } else {

            // Duplicate values are not allowed
            return root;
        }

        // Update height after insertion
        updateHeight(root);

        // Check balance factor
        int balance = getBalance(root);

        // =====================================================
        // CASE 1: LL
        // =====================================================
        if (balance > 1 && data < root.left.data) {

            return rightRotate(root);
        }

        // =====================================================
        // CASE 2: RR
        // =====================================================
        if (balance < -1 && data > root.right.data) {

            return leftRotate(root);
        }

        // =====================================================
        // CASE 3: LR
        // =====================================================
        if (balance > 1 && data > root.left.data) {

            root.left = leftRotate(root.left);

            return rightRotate(root);
        }

        // =====================================================
        // CASE 4: RL
        // =====================================================
        if (balance < -1 && data < root.right.data) {

            root.right = rightRotate(root.right);

            return leftRotate(root);
        }

        // No rotation required
        return root;
    }

    // =========================================================
    // FIND MINIMUM NODE
    // Used during deletion
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
    // DELETE
    // =========================================================
    Node delete(Node root, int data) {

        // Normal BST deletion
        if (root == null) {
            return null;
        }

        if (data < root.data) {

            root.left = delete(root.left, data);

        } else if (data > root.data) {

            root.right = delete(root.right, data);

        } else {

            // ================================================
            // CASE 1: No child
            // ================================================
            if (root.left == null && root.right == null) {

                return null;
            }

            // ================================================
            // CASE 2: Only right child
            // ================================================
            if (root.left == null) {

                return root.right;
            }

            // ================================================
            // CASE 3: Only left child
            // ================================================
            if (root.right == null) {

                return root.left;
            }

            // ================================================
            // CASE 4: Two children
            // ================================================

            // Find inorder successor
            Node successor = findMin(root.right);

            // Copy successor's data
            root.data = successor.data;

            // Delete successor
            root.right = delete(root.right, successor.data);
        }

        // Update height
        updateHeight(root);

        // Check balance
        int balance = getBalance(root);

        // =====================================================
        // LL CASE
        // =====================================================
        if (balance > 1 && getBalance(root.left) >= 0) {

            return rightRotate(root);
        }

        // =====================================================
        // LR CASE
        // =====================================================
        if (balance > 1 && getBalance(root.left) < 0) {

            root.left = leftRotate(root.left);

            return rightRotate(root);
        }

        // =====================================================
        // RR CASE
        // =====================================================
        if (balance < -1 && getBalance(root.right) <= 0) {

            return leftRotate(root);
        }

        // =====================================================
        // RL CASE
        // =====================================================
        if (balance < -1 && getBalance(root.right) > 0) {

            root.right = rightRotate(root.right);

            return leftRotate(root);
        }

        return root;
    }

    // =========================================================
    // SEARCH
    // =========================================================
    boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // =========================================================
    // INORDER
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
    // PREORDER
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
    // POSTORDER
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

        AVLTreeImplementation tree = new AVLTreeImplementation();

        // Insert values
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 10);

        /*
             Before rotation:

                 30
                /
               20
              /
             10

             LL imbalance

             After Right Rotation:

                 20
                /  \
              10    30
        */

        System.out.println("After LL case:");
        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        // Add more nodes
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);

        /*
             RR imbalance can occur while inserting 50.
             AVL automatically performs left rotation.
        */

        System.out.println("\nAfter adding 40 and 50:");

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        // Search
        int key = 40;

        if (tree.search(tree.root, key)) {
            System.out.println("\n" + key + " found");
        } else {
            System.out.println("\n" + key + " not found");
        }

        // Delete
        tree.root = tree.delete(tree.root, 40);

        System.out.println("\nAfter deleting 40:");

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();
    }
}