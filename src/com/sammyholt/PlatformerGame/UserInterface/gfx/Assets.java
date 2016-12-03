package com.sammyholt.PlatformerGame.UserInterface.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	/**
	 * The path to the sprite sheet file.
	 */
	private static String sheetPath = "/textures/spritesheettest.png";
	
	/**
	 * This size, in pixels, of each sprite on the sprite sheet.
	 */
	private static final int spriteSize = 40;
	
	/**
	 * This declares all of the assets which will be loaded from the sprite sheet.
	 */
	public static BufferedImage player, twitter, gmail, dirt, linkedin, tumblr;
	
	/**
	 * This method will load every asset into the game.  It should only be called once.
	 */
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(sheetPath));
		
		dirt = sheet.crop(0, 0, spriteSize);
		player = sheet.crop(0, 1, spriteSize);
		gmail = sheet.crop(0, 2, spriteSize);
		linkedin = sheet.crop(0, 3, spriteSize);
		tumblr = sheet.crop(0, 4, spriteSize);
		twitter = sheet.crop(0, 5, spriteSize);
	}

}
