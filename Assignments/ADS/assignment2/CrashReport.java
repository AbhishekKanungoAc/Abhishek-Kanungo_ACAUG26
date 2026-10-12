package assignment2;

public class CrashReport {
	
	String arr[];
	int top ;
	int capacity;
	
		CrashReport(int c){
			capacity = c;
			arr = new String[c];
			top =-1;
		}
	
		
		public void enter(String s) {
			if(top == capacity - 1) {
				System.out.println("Stack is Overflow");
				return;
			}
			arr[++top] = s;
			
		} 
	
		public String exit() {
			if(top == -1) {
				System.out.println("Stack is empty");
				return null;
			}
			return arr[top--];
		}
		
		public void display() {
			if(top == -1) {
				System.out.println("Stack is empty");
				return;
			}
			
			for(int i=top;i>=0;i--) {
				System.out.println(arr[i]);
			}
			
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c=4;
		CrashReport cr = new CrashReport(c);
		cr.enter("main");
		cr.enter("placeOrder");
		cr.enter("validateCart");
		cr.exit();
		cr.enter("processPayment");
		cr.enter("connectBank");
		cr.display();
	

	}
}
