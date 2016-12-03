package com.sammyholt.PlatformerGame;

import com.sammyholt.PlatformerGame.UserInterface.*;

/**
 * This class holds the main method.
 * 
 * @author Sammy Holt
 *
 */

public class Launcher {
	
	public static void main(String[] args){
		UserInterface ui = new UserInterface("Hey!", 800, 800);
		ui.start();
	}
	
}