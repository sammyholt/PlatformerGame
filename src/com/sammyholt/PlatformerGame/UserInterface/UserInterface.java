package com.sammyholt.PlatformerGame.UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.sammyholt.PlatformerGame.GameEngine;
import com.sammyholt.PlatformerGame.UserInterface.gfx.Assets;
import com.sammyholt.PlatformerGame.UserInterface.gfx.ImageLoader;
import com.sammyholt.PlatformerGame.UserInterface.gfx.SpriteSheet;
import com.sammyholt.PlatformerGame.states.GameState;
import com.sammyholt.PlatformerGame.states.State;

public class UserInterface implements Runnable {
	
	/**
	 * Frames per second of the game.
	 */
	private int fps = 60;
	
	/**
	 * Maximum amount of time to run the tick and render methods
	 * to achieve goal {@link #fps}.
	 */
	private double timePerTick = 1000000000 / fps;
	
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
	
	/**
	 * This represents the BufferStrategy of the UI.
	 */
	private BufferStrategy bs;
	
	/**
	 * This represents the graphics of the UI.
	 */
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
	
	/**
	 * Initializes the frame.
	 */
	private void init(){
		display = new Display(title, width, height);
		Assets.init();
		
		game.setGameState(new GameState());
		game.setMenuState(new MenuState());
		
		State.setState(game.getGameState());
		
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
		
		clearScreen();
		
		// Drawing Starts
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		// End drawing
		
		// show the buffer and get rid of graphics object
		bs.show();
		g.dispose();
	}
	
	/**
	 * This method will clear the screen of all graphics.
	 */
	private void clearScreen(){
		g.clearRect(0, 0, display.getWidth(), display.getHeight());
	}
	
	/**
	 * The main loop of the game.
	 */
	private void gameLoop(){
		// initialize fields for timer
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		while(game.isRunning()){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				game.tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
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
