package Practiesproblems;

public class StudentList {

	class List {
		String name;
		List next;

		List(String name) {
			this.name = name;
			this.next = null;
		}
	}

	List head = null;

	// insertion of student
	void insertAtBeginning(String data) {
		List newList = new List(data);

		newList.next = head;
		head = newList;
	}

	// insertion At end

	void insertAtEnd(String data) {
		List newList = new List(data);

		if (head == null) {
			head = newList;
			return;
		}

		List temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newList;
	}
	
	
	

	// insertAtAnypos
	void insertAtpos(int pos, String data) {
		List newList = new List(data);

		if (pos < 0) {
			System.out.println("Invailde postion!!");
			return;
		}
		if (pos == 1) {
			insertAtBeginning(data);
			return;
		}

		List temp = head;
		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Postion does not exist");
			return;
		}

		newList.next = temp.next;
		temp.next = newList;

	}

	// delete at beginning
	void deleteAtBeginning() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		head = head.next;
	}

	// delete at end
	void deleteAtEnd() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		List temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
	
	//Delete at any postion
	void deleteAtPos(int pos) {
			if (pos < 0) {
				System.out.println("Invailde postion!!");
				return;
			}
			if (pos == 1) {
				deleteAtBeginning();
				return;
			}

			List temp = head;
			for (int i = 1; i < pos - 1 && temp != null; i++) {
				temp = temp.next;
			}

			if (temp == null) {
				System.out.println("Postion does not exist");
				return;
			}
			temp.next = temp.next.next;
		
	}

	//Delete by name
	void deleteByName(String name) {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		
		if(head.name.equals(name)) {
			head = head.next;
			return;
		}
		
		
		List temp =head;
	while(temp.next != null && !temp.next.name.equals(name)) {
		temp = temp.next;
	}
	
	if(temp.next  == null) {
		System.out.println("Student not found");
		return;
	}
	
	temp.next = temp.next.next;
		
		
		
		
	}
	
	//Search 
	
	void searchName(String name) {
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		
		List temp = head;
		while(temp != null) {
			if(temp.name.equals(name)) {
				System.out.println(temp.name+"  found");
				return;
			}
			temp = temp.next;
		}
			System.out.println("Student not found");
	}
	
	
	// Display of student

	void display() {

		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		List temp = head;
		while (temp != null) {
			System.out.print(temp.name + " -> ");
			temp = temp.next;
		}
		System.out.println("Null");

	}
	
	


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentList sl = new StudentList();
		sl.display();
		sl.insertAtBeginning("chiranjive");
		sl.insertAtBeginning("Bhavna");
		sl.insertAtBeginning("Abhishek");
		System.out.println("After insertion at beginning:");
		sl.display();

		sl.insertAtEnd("Ramji");
		System.out.println("After insertion at End:");

		sl.display();
		sl.insertAtpos(2, "SecondPos");

		System.out.println("After insertion at Postion:");
		sl.display();
		
		System.out.println("Search By Name=============:");
		sl.searchName("Bhavna");
		sl.searchName("Abhi");
		
		
		
		
		
		System.out.println("After deletion at beginning:");

		sl.deleteAtBeginning();
		sl.display();
		System.out.println("After deletion at End:");
		sl.deleteAtEnd();
		sl.display();

		System.out.println("After deletion at pos:");
		sl.deleteAtPos(2);
		sl.display();
		
		
		System.out.println("deletion by Name:");
		sl.deleteByName("SecondPos");
		sl.display();
	}

}
