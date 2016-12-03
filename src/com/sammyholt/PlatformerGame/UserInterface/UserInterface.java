package com.sammyholt.PlatformerGame.UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.sammyholt.PlatformerGame.*;

public class UserInterface implements Runnable {
	
	/**
	 * This field represents the title of the main window.
	 */
	private String title;
	
	/**
	 * This field represents the width of the main window.
	 */
	private int width;
	
	/**
	 * This field represents the height of the main window.
	 */
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
	
	private BufferStrategy bs;
	
	private Graphics g;
	
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
	
	/**
	 * Renders the game graphics out to the canvas.
	 */
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// Drawing Starts
		
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		
		// End drawing
		
		bs.show();
		g.dispose();
	}
	
	/**
	 * The main loop of the game.
	 */
	private void gameLoop(){
		while(game.isRunning()){
			game.tick();
			render();
		}
	}
	
	/**
	 * This method allows for the thread to be run.
	 */
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
