package functions;

import screens.FileOperations;
import screens.VirtualKeyScreens;
import screens.WelcomeScreen;

public class ScreenService {
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOperations FileOperationScreen = new FileOperations();
    
    public static VirtualKeyScreens CurrentScreen = WelcomeScreen;



	public static VirtualKeyScreens getCurrentScreen() {
		return CurrentScreen;
	}



	public static void setCurrentScreen(VirtualKeyScreens currentScreen) {
		CurrentScreen = currentScreen;
	}
	

}
