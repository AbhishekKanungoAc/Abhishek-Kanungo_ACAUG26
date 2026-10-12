package Practiesproblems;

public class QueueThroughArray {
	
	int arr[];
	int cap;
	int front;
	int rear;
		

	public QueueThroughArray(int c) {
		cap =c;
		arr = new int[c];
		front = -1;
		rear = -1;
	
	}
	//adding element
	public void enqueue(int n) {
		if(rear == cap-1) {
			System.out.println("Queue Overflow");
			return;
		}
		if(front == -1) {
			front =0;
		}
		rear++;
		arr[rear] =n;
	}
	
	public boolean isEmpty() {
		return rear == -1;
	}
	public boolean isFull() {
		return rear == cap-1;
	}
	
	
	//remove element
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		
		int v =arr[front++];
		if(front>rear) {
			front = -1;
			rear = -1;
		}
		return v;
		
		
	}
	
	//Search
	public void search(int data) {
		for(int i=front;i<=rear;i++) {
			if(arr[i] == data) {
				System.out.println(arr[i]+" Found at index : "+ i);
				return;
			}
			
		}
		System.out.println("Not Found");

	}
	
	
	//display
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Queue: ");
		for(int i=front; i<=rear; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c =4;
		QueueThroughArray qa = new QueueThroughArray(c);
		qa.enqueue(20);
		qa.enqueue(15);
		qa.enqueue(10);
		qa.enqueue(5);
		System.out.println("4 elements");
		qa.display();
		
		System.out.println("5 elements");
		qa.enqueue(1);
		qa.display();
		System.out.println("queue is empty "+qa.isEmpty());
		
		System.out.println("queue is full "+qa.isFull());
		System.out.println("First ele is removed: "+qa.dequeue());
		qa.display();
		System.out.println("First ele is removed: "+qa.dequeue());
		qa.display();
		System.out.println("queue is full "+qa.isFull());
		qa.display();
		
		qa.search(5);
		
	}

}
