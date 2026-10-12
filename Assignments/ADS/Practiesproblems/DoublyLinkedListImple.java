package Practiesproblems;



public class DoublyLinkedListImple {

    // =========================================================
    // NODE
    // =========================================================
    static class Node {

        int data;

        Node prev;   // Points to previous node
        Node next;   // Points to next node

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    // =========================================================
    // 1. INSERT AT BEGINNING
    // =========================================================
    void insertAtBeg(int data) {

        Node newNode = new Node(data);

        // New node points to current first node
        newNode.next = head;

        // If list is not empty,
        // old first node points back to new node
        if (head != null) {
            head.prev = newNode;
        }

        // New node becomes head
        head = newNode;
    }

    // =========================================================
    // 2. INSERT AT END
    // =========================================================
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect last node with new node
        temp.next = newNode;

        // New node points back to last node
        newNode.prev = temp;
    }

    // =========================================================
    // 3. INSERT AT ANY POSITION
    // Position starts from 1
    // =========================================================
    void insertAtPos(int data, int pos) {

        if (pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        // Position 1 means beginning
        if (pos == 1) {
            insertAtBeg(data);
            return;
        }

        Node temp = head;

        // Reach node just before required position
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Position does not exist
        if (temp == null) {
            System.out.println("Position does not exist");
            return;
        }

        Node newNode = new Node(data);

        // Connect new node with next node
        newNode.next = temp.next;

        // Connect new node with previous node
        newNode.prev = temp;

        // If new node is not inserted at the end,
        // update the next node's prev
        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        // Previous node points to new node
        temp.next = newNode;
    }

    // =========================================================
    // 4. DELETE FROM BEGINNING
    // =========================================================
    void deleteFromBeg() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Move head to second node
        head = head.next;

        // New head has no previous node
        if (head != null) {
            head.prev = null;
        }
    }

    // =========================================================
    // 5. DELETE FROM END
    // =========================================================
    void deleteFromEnd() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Previous node becomes the last node
        temp.prev.next = null;
    }

    // =========================================================
    // 6. DELETE FROM ANY POSITION
    // Position starts from 1
    // =========================================================
    void deleteFromPos(int pos) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        // Position 1 means beginning
        if (pos == 1) {
            deleteFromBeg();
            return;
        }

        Node temp = head;

        // Reach node to be deleted
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        // Position does not exist
        if (temp == null) {
            System.out.println("Position does not exist");
            return;
        }

        // Connect previous node to next node
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        // Connect next node to previous node
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // =========================================================
    // 7. FORWARD TRAVERSAL
    // =========================================================
    void displayForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // =========================================================
    // 8. BACKWARD TRAVERSAL
    // =========================================================
    void displayBackward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // First reach the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Move backwards using prev
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }

    // =========================================================
    // 9. SEARCH
    // =========================================================
    boolean search(int key) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // =========================================================
    // 10. COUNT NODES
    // =========================================================
    int count() {

        int count = 0;

        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        DoublyLinkedListImple dl = new DoublyLinkedListImple();

        // Insert at beginning
        dl.insertAtBeg(20);
        dl.insertAtBeg(10);

        System.out.println("After insertion at beginning:");
        dl.displayForward();

        // Insert at end
        dl.insertAtEnd(30);
        dl.insertAtEnd(40);

        System.out.println("After insertion at end:");
        dl.displayForward();

        // Insert at position
        dl.insertAtPos(25, 3);

        System.out.println("After insertion at position 3:");
        dl.displayForward();

        // Forward traversal
        System.out.println("Forward traversal:");
        dl.displayForward();

        // Backward traversal
        System.out.println("Backward traversal:");
        dl.displayBackward();

        // Delete from beginning
        dl.deleteFromBeg();

        System.out.println("After deletion from beginning:");
        dl.displayForward();

        // Delete from end
        dl.deleteFromEnd();

        System.out.println("After deletion from end:");
        dl.displayForward();

        // Delete from position
        dl.deleteFromPos(2);

        System.out.println("After deletion from position 2:");
        dl.displayForward();

        // Search
        int key = 30;

        if (dl.search(key)) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }

        // Count
        System.out.println("Total nodes: " + dl.count());
    }
}