package screens;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import functions.Directory;

public class FileOperations implements   VirtualKeyScreens  {

	private Directory dr = new Directory();
	
	ArrayList<String> options = new ArrayList<>();
			
	public FileOperations() {
	
		options.add("1. Add a File");
		options.add("2. Delete a File");
		options.add("3. Search a File");
		options.add("4. Return to main options");
	}
	
	
	@Override
	public void showMenu() {
		for (String s : options) {
			System.out.println(s);
		}
		
	}

	@Override
	public void getInputFromUser() {
		int selectedOption;
		while((selectedOption = this.getOption()) != 4)
		{
			this.navigateOption(selectedOption);
		}
		System.out.println("\nNagivating To Main option Screen");
	}

	@Override
	public void navigateOption(int option) {
		switch(option) 
		{

        case 1: // Add File
        	System.out.println("\nAdding files");
            this.AddFile();
            System.out.println("\n");
            this.showMenu();
            break;
            
        case 2: // Delete File
        	System.out.println("\nDeleting file");
            this.DeleteFile();
            this.showMenu();
        	break;
       
        case 3: // Search File
        	System.out.println("Searching files");
            this.SearchFile();
            this.showMenu();
            break;
                   
        default:
            System.out.println("\nInvalid Option");
            this.showMenu();
            break;
         }
	}

	
	 private int getOption() {
	        Scanner in = new Scanner(System.in);

	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid input");
	        }
	        return returnOption;

	    }

	 
	 public void AddFile() {
		 
		System.out.println("Enter File Name with extension");
		String fileName = this.getinputString();
		System.out.println("Adding file : " + fileName);
		
		try {
		
			Path path = FileSystems.getDefault().getPath(Directory.name, fileName).toAbsolutePath();
			File file = new File(dr.getName() + fileName);
			
			if (file.createNewFile()) {
				System.out.println("File Created : " + file.getName());
				dr.getFiles().add(file);
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	 }
	
	 public void DeleteFile() {
		 System.out.println("\nPlease Enter File Name with Extension:");
		 
		 String fileName = this.getinputString();
		 Path path = FileSystems.getDefault().getPath(Directory.name, fileName).toAbsolutePath();
		 File file = new File(dr.getName() + fileName);
		 
		 if (file.delete()) {
			 System.out.println("\nDeleted file : " + file.getName());
			 dr.getFiles().remove(file);
		} else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
		 
	 }

	 public void SearchFile() {
		 Boolean found = false;
		 System.out.println("\nEnter File Name To Search");
		 
		 String fileName = this.getinputString();
		 
		 System.out.println("\nYou are Searching For File Name : " + fileName);
		 
		 ArrayList<File> files = dr.getFiles();
		 
		 for(int i = 0; i < files.size(); i++) {
				if(files.get(i).getName().equals(fileName)) {
					System.out.println("Found File Name : " + fileName);
					found = true;
				}
	        }
	        if (found == false) {
	        	System.out.println("File not found");
	        } 
	 }
	 
	 private String getinputString() {
		 Scanner sc = new Scanner(System.in);
		 String fileName = sc.nextLine();
		 return fileName;
	 }
}
