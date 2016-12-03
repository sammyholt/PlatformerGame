package com.sammyholt.PlatformerGame.tiles;

import com.sammyholt.PlatformerGame.UserInterface.gfx.Assets;

public class TumblrTile extends Tile {

	public TumblrTile(int id) {
		super(Assets.tumblr, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
