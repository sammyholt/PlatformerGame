package com.sammyholt.PlatformerGame.UserInterface;

import com.sammyholt.PlatformerGame.*;

public class UserInterface implements Runnable {
	
	private String title;
	
	private int width;
	
	private int height;
	
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
		this.title = Display.defaultTitle;
		this.width = Display.defaultWidth;
		this.height = Display.defaultHeight;
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
		this.title = title;
		this.width = width;
		this.height = height;
		game = new GameEngine();
	}
	
	private void init(){
		display = new Display(title, width, height);
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
		gameLoop();
		stop();
	}
	
	/**
	 * This method will start the {@link #thread}.
	 */
	public synchronized void start(){
		if(game.isRunning()){
			// do nothing, already running
		}else{
			game.setRunning(true);
			thread = new Thread(this);
			thread.start();
		}	
	}
	
	/**
	 * This method will stop the {@link #thread}.
	 */
	public synchronized void stop(){
		if(!game.isRunning()){
			// do nothing, already stopped
		}else{
			game.setRunning(false);
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
