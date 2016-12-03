package com.sammyholt.PlatformerGame.states;

import java.awt.Graphics;

import com.sammyholt.PlatformerGame.UserInterface.UserInterface;
import com.sammyholt.PlatformerGame.entities.creatures.Player;
import com.sammyholt.PlatformerGame.tiles.Tile;

public class GameState extends State {
	
	private Player player;
	
	public GameState(UserInterface game){
		super(game);
		player = new Player(game, 100, 100);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
