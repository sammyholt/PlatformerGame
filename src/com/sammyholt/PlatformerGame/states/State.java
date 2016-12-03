package com.sammyholt.PlatformerGame.states;

import java.awt.Graphics;

import com.sammyholt.PlatformerGame.UserInterface.UserInterface;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	protected UserInterface game;
	
	public State(UserInterface game){
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
