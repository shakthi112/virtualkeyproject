package screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import functions.FileList;
import functions.ScreenService;


public class WelcomeScreen  implements VirtualKeyScreens{

	private	String welcomeText = "Welcome To virtual Key Project";
	private	String	developerText = "Develope By Shakthi";
	
	public	ArrayList<String>	options = new ArrayList<>();

	public WelcomeScreen() {
		options.add("1.Show files");
		options.add("2.Show file option menu");
		options.add("3.Exit application");
	}
	
	public void Appinfo()
	{
		System.out.println(welcomeText);
		System.out.println(developerText);
		System.out.println("\n");
		this.showMenu();
	}

	@Override
	public void showMenu() {

		for (String s : options) {
			System.out.println(s);	
		}
		
	}

	@Override
	public void getInputFromUser() {
		int selectedOption ;
		while((selectedOption = this.getOption()) != 3)
			this.navigateOption(selectedOption);
		System.out.println("*********Thank you For Using Virtual Key**********");
		System.out.println("***************Closing The App*********************");
		
	}

	@Override
	public void navigateOption(int option) {
		switch (option) {
		case 1://Show Files 
			System.out.println("Show files in the directory");
			this.ShowFiles();
			System.out.println("\n");
			this.showMenu();
			break;
		
		case 2:// nagivating to file Operation
			System.out.println("\nShow files operations");
			ScreenService.setCurrentScreen(ScreenService.FileOperationScreen);		
			ScreenService.getCurrentScreen().showMenu();
            ScreenService.getCurrentScreen().getInputFromUser();
            System.out.println("\n");
            this.showMenu();
            break;
			
		default:
			System.out.println("Please enter valid Option");
			System.out.println("\n");
			this.showMenu();
			break;
			
		}
		
	}
	
	public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("\nBelow are List of Files : ");
    	FileList.printfiles();
 

    }
	
	public int getOption() 
	{
		Scanner input = new Scanner(System.in);
		int Option = 0;
		try {
		
			System.out.println("\nPlease enter your choice");
			Option = input.nextInt();
		
		} 
		catch (InputMismatchException ex) {
		System.out.println("Enter only numbers");	
		}
		return	Option;
	}
}
