package com.sammyholt.PlatformerGame.UserInterface.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	/**
	 * This field represents the sprite sheet loaded image.
	 */
	private BufferedImage sheet;
	
	/**
	 * The default constructor for the SpriteSheet.
	 * @param sheet
	 */
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	/**
	 * Returns a buffered image from the specified parameters.  The top left of
	 * the sprite sheet is considered to be gridRow = 0 and gridColumn = 0,
	 * 
	 * @param gridRow - The row of the image from the sheet.
	 * @param gridColumn - The column of the image from the sheet.
	 * @param spriteSize - The size of each sprite (ex: 32 pixels x 32 pixels, spriteSize = 32)
	 * @return BufferedImage croppedImage
	 */
	public BufferedImage crop(int gridRow, int gridColumn, int spriteSize){
		return sheet.getSubimage(gridColumn * spriteSize, gridRow * spriteSize, spriteSize, spriteSize);
	}
	

}
