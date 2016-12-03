package com.sammyholt.PlatformerGame.UserInterface;

import com.sammyholt.PlatformerGame.*;

public class UserInterface implements Runnable {
	
	/**
	 * The main display for the game.
	 */
	private Display display;
	
	/**
	 * The main thread for this {@link UserInterface}.
	 */
	private Thread thread;
	
	/**
	 * The game used in this interface.
	 */
	private GameEngine game;
	
	/**
	 * The default constructor.
	 */
	public UserInterface(){
		display = new Display();
		game = new GameEngine();
	}
	
	/**
	 * The constructor which takes arguments for the main window.
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public UserInterface(String title, int width, int height){
		display = new Display(title, width, height);
		game = new GameEngine();
	}
	
	private void init(){
		
	}
	
	private void render(){
		
	}
	
	private void gameLoop(){
		while(game.isRunning()){
			game.tick();
			render();
		}
	}

	@Override
	public void run() {
		
		init();
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
