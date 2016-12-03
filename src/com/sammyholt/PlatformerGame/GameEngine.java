package com.sammyholt.PlatformerGame;

public class GameEngine {
	
	/**
	 * A boolean value which represents if the game is running or not.
	 */
	private boolean running;
	
	/**
	 * 
	 */
	public void tick(){
		
	}
	
	/**
	 * 
	 * @return {@link #running} - A boolean value which represents if the game is running or not.
	 */
	public boolean isRunning(){
		return running;
	}
	
	/**
	 * This method allows the {@link #running} field to be changed outside the class.
	 * 
	 * @param running
	 */
	public void setRunning(boolean running){
		this.running = running;
	}

}
