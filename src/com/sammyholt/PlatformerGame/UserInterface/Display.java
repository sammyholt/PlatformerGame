package com.sammyholt.PlatformerGame.UserInterface;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class contains the attributes and behaviors 
 * of the GUI (or {@link Display}).
 * 
 * @author Sammy Holt
 *
 */

public class Display {
	
	/**
	 * This field represents the main frame of the game.
	 * It is the main window which displays to the screen.
	 */
	private JFrame frame;
	
	/**
	 * This field represents the {@link Canvas} on the {@link #frame}.
	 */
	private Canvas canvas;
	
	/**
	 * This field represents the {@link #title} of the {@link #frame}.
	 */
	private String title;
	
	/**
	 * This field represents the {@link #width} of the {@link #frame}.
	 */
	private int width;
	
	/**
	 * This field represents the {@link #height} of the {@link #frame}.
	 */
	private int height;
	
	/**
	 * This field represents an awt {@link Dimension} object with the
	 * {@link #width} and {@link #height} fields as parameters.
	 */
	private Dimension dimension;
	
	/**
	 * The default title for the {@link #frame}.
	 */
	public static String defaultTitle = "Platformer Game";
	
	/**
	 * The default width for the {@link #frame}.
	 */
	public static int defaultWidth = 800;
	
	/**
	 * The default height for the {@link #frame}.
	 */
	public static int defaultHeight = 800;
	
	/**
	 * The default constructor for the {@link Display}.
	 */
	public Display(){
		this.title = defaultTitle;
		this.width = defaultWidth;
		this.height = defaultHeight;
		dimension = new Dimension(width, height);
		
		createDisplay();
	}
	
	/**
	 * This constructor allows for the parameters to be set for the {@link Display}.
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		dimension = new Dimension(width, height);
		
		createDisplay();
	}
	
	/**
	 * This method will initialize everything necessary to
	 * create the main display window.
	 */
	private void createDisplay(){
		initializeFrame();
		initializeCanvas();
	}
	
	/**
	 * This method will initialize the {@link #frame}.
	 */
	private void initializeFrame(){
		frame = new JFrame(title);
		frame.setSize(dimension);
		frame.setPreferredSize(dimension);
		frame.setMaximumSize(dimension);
		frame.setMinimumSize(dimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * This method will initialize the {@link #canvas}.
	 */
	private void initializeCanvas(){
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		
		frame.add(canvas);
		frame.pack();
	}
	
	/**
	 * 
	 * @return {@link #width} - The current width value of this display.
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @return {@link #height} - The current height value of this display.
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * @return {@link #title} - The current title of this display.
	 */
	public String getTitle(){
		return this.title;
	}

}
