package Practiesproblems;

class Node{
	
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next =null;
	}

}



public class LinkedListImplemention {

	
	static Node insertAtBeg(Node head, int data) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		return newNode;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head = new Node(10);
		head.next =new Node(20);
		
		head.next.next= new Node(30);
		
		
		Node temp =head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp =temp.next;
		}
		
	}

}
