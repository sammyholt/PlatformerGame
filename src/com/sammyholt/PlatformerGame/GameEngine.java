package com.sammyholt.PlatformerGame;

import com.sammyholt.PlatformerGame.display.*;

public class GameEngine {
	
	/**
	 * The main display for the game.
	 */
	private Display display;
	
	/**
	 * The default constructor.
	 */
	public GameEngine(){
		display = new Display();
	}
	
	/**
	 * The constructor which takes arguments for the main window.
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public GameEngine(String title, int width, int height){
		display = new Display(title, width, height);
	}

}
