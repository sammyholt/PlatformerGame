package com.sammyholt.PlatformerGame;

import com.sammyholt.PlatformerGame.states.State;

public class GameEngine {
	
	/**
	 * A boolean value which represents if the game is running or not.
	 */
	private boolean running;
	
	//States
	private State gameState;
	private State menuState;
	
	/**
	 * 
	 */
	public void tick(){
		if(State.getState() != null){
			State.getState().tick();
		}
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
	
	/**
	 * Sets the {@link #gameState} based on the parameter.
	 * 
	 * @param gameState - A passed state which changes the current gameState.
	 */
	public void setGameState(State gameState){
		this.gameState = gameState;
	}
	
	/**
	 * @return {@link #gameState} - The current state of the game.
	 */
	public State getGameState(){
		return gameState;
	}
	
	/**
	 * Sets the {@link #gameState} based on the parameter.
	 * 
	 * @param gameState - A passed state which changes the current gameState.
	 */
	public void setMenuState(State menuState){
		this.menuState = menuState;
	}
	
	/**
	 * @return {@link #gameState} - The current state of the game.
	 */
	public State getMenuState(){
		return menuState;
	}

}
