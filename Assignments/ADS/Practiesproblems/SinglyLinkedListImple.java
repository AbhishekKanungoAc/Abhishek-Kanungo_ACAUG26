package Practiesproblems;

public class SinglyLinkedListImple {

    // Node represents one element of the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // =========================================================
    // 1. INSERTION AT BEGINNING
    // =========================================================
    void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        // New node points to the current first node
        newNode.next = head;

        // New node becomes the first node
        head = newNode;
    }

    // =========================================================
    // 2. INSERTION AT END
    // =========================================================
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // If list is empty, new node becomes head
        if (head == null) {
            head = newNode;
            return;
        }

        // Start from head and move to the last node
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Last node points to the new node
        temp.next = newNode;
    }

    // =========================================================
    // 3. INSERTION AT A GIVEN POSITION
    // Position starts from 1
    // =========================================================
    void insertAtPosition(int data, int position) {

        // Invalid position
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        // Position 1 means insertion at beginning
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);

        Node temp = head;

        // Reach the node just before required position
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Position is greater than list size
        if (temp == null) {
            System.out.println("Position does not exist");
            return;
        }

        // Connect new node between temp and temp.next
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // =========================================================
    // 4. DELETE FROM BEGINNING
    // =========================================================
    void deleteFromBeginning() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Move head to the second node
        head = head.next;
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

        // Stop at second-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove the last node
        temp.next = null;
    }

    // =========================================================
    // 6. DELETE FROM A GIVEN POSITION
    // Position starts from 1
    // =========================================================
    void deleteFromPosition(int position) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        // Delete first node
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        // Reach the node before the node to delete
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Position does not exist
        if (temp.next == null) {
            System.out.println("Position does not exist");
            return;
        }

        // Skip the node that has to be deleted
        temp.next = temp.next.next;
    }

    // =========================================================
    // 7. TRAVERSAL / DISPLAY
    // =========================================================
    void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // Visit every node from head to null
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // =========================================================
    // 8. SEARCH
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
    // 9. COUNT NUMBER OF NODES
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
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        SinglyLinkedListImple list = new SinglyLinkedListImple();

        // Insert at beginning
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        System.out.println("After insertion at beginning:");
        list.display();

        // Insert at end
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("After insertion at end:");
        list.display();

        // Insert at position
        list.insertAtPosition(25, 3);

        System.out.println("After insertion at position 3:");
        list.display();

        // Delete from beginning
        list.deleteFromBeginning();

        System.out.println("After deletion from beginning:");
        list.display();

        // Delete from end
        list.deleteFromEnd();

        System.out.println("After deletion from end:");
        list.display();

        // Delete from position
        list.deleteFromPosition(2);

        System.out.println("After deletion from position 2:");
        list.display();

        // Search
        int key = 30;

        if (list.search(key)) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }

        // Count
        System.out.println("Total nodes: " + list.count());
    }
}