package com.sammyholt.PlatformerGame.entities.creatures;

import java.awt.Graphics;

import com.sammyholt.PlatformerGame.UserInterface.UserInterface;
import com.sammyholt.PlatformerGame.UserInterface.gfx.Assets;

public class Player extends Creature {
	
	private UserInterface game;

	public Player(UserInterface game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, this.getXInt(), this.getYInt(), this.getWidth(), this.getHeight(), null);
		
	}

}
