package org.abhishek.classcode;
import java.io.File;
//day 10.1  
public class Files {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rootDirectory = new File("C:\\Users");
		System.out.println("\"Hello world!!\"");
		String [] allFiles = rootDirectory.list();
		
		for (String file : allFiles) {
			System.out.println(file);
		}

	}
	
	

}
