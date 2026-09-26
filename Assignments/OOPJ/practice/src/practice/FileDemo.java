package practice;

import java.io.File;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data.txt");
		File temp = new File("temp.txt");
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n=============================="); 
			System.out.println(" FILE MENU"); 
			System.out.println("=============================="); 
			System.out.println("1. Create and Check File");
			System.out.println("2. Copy File"); 
			
			System.out.println("3. Encrypt File"); 
			System.out.println("4. Decrypt File"); 
			System.out.println("5. Exit"); 
			System.out.println("==============================");
			System.out.println("Enter the chaice: ");
			choice = sc.nextInt();
		
			
			
			switch(choice) {
			case 1: 
				createAndCheck(file);
				break;
			case 2:
				fileCopied(file);
				break;
			case 3:
				encriptionFile(file,temp);
				break;
			case 4:
				decryptionFile(file,temp);
				break;
			case 5:
				System.out.println("Program Exited!!");
				break;
			default:
				System.out.println("Invalide choice");
				
			}
		}while(choice != 5);
sc.close();
	}
	

	private static void createAndCheck(File file) {
		
		
		
		try {
			if(file.createNewFile()) {
				System.out.println("File created sucessfuly.");
			}else {
				System.out.println("File already exists.");
			}
			
			
			System.out.println("Exists: "+file.exists());
			
			System.out.println("Name: " +file.getName());
			
			System.out.println("Path: "+file.getAbsolutePath());
	
			
			System.out.println("Is File: "+file.isFile());
			
			System.out.println("Is Directory: "+file.isDirectory());
			
			System.out.println("Size: "+file.length()+" bytes");
			
			FileWriter fw = new FileWriter("data.txt");
			fw.write("Hello java\n");
			fw.write("I am learning java.\n");
			fw.write("This is filewriter.\n");
			fw.close();
			System.out.println("Data written successfully.");
		
		}catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}

	private static void fileCopied(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data.txt"));	
			 BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"));
			 
			 String line;
			 
			 while((line = br.readLine()) != null) {
				 bw.write(line);
				 bw.newLine();
			 }
			 br.close();
			 bw.close();
					
			 System.out.println("File copied successfully.");
		}catch(IOException e ) {
						System.out.println("Error: "+e.getMessage());
					}
	}
	
	
	
	private static void encriptionFile(File file , File temp) {
		System.out.println("==================encryption=======================");
		
		
		try {
			BufferedReader brr = new BufferedReader(new FileReader(file));
			BufferedWriter bww = new BufferedWriter(new FileWriter(temp) );
			
			int ch ;
			while((ch = brr.read()) != -1) {
				ch = ch+3;
				bww.write(ch);
				
			}
			brr.close();
			bww.close();
			
			if (file.delete()) { System.out.println("Original file deleted."); }
			if (temp.renameTo(file)) {
				System.out.println("Encrypted file saved as data.txt."); } 
			else
			{ System.out.println("File rename failed.");
			}
			
			System.out.println("File encrypted successfully");
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	private static void decryptionFile(File file, File temp) {
		System.out.println("==================decryption=======================");
		
		
		try {
			BufferedReader brr = new BufferedReader(new FileReader(file));
			BufferedWriter bww = new BufferedWriter(new FileWriter(temp) );
			
			int ch ;
			while((ch = brr.read()) != -1) {
				ch = ch-3;
				bww.write(ch);
				
			}
			brr.close();
			bww.close();
			
			if (file.delete()) { System.out.println("Original file deleted."); }
			if (temp.renameTo(file)) {
				System.out.println("Encrypted file saved as data.txt."); } 
			else
			{ System.out.println("File rename failed.");
			}
			
			System.out.println("File encrypted successfully");
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	

}
