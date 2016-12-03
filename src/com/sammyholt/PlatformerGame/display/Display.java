package com.sammyholt.PlatformerGame.display;

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
	private Dimension dimension = new Dimension(width,height);
	
	/**
	 * The default title for the {@link #frame}.
	 */
	private static String defaultTitle = "Platformer Game";
	
	/**
	 * The default width for the {@link #frame}.
	 */
	private static int defaultWidth = 800;
	
	/**
	 * The default height for the {@link #frame}.
	 */
	private static int defaultHeight = 800;
	
	/**
	 * The default constructor for the {@link Display}.
	 */
	public Display(){
		this.title = defaultTitle;
		this.width = defaultWidth;
		this.height = defaultHeight;
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
		frame.setSize(width, height);
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

}
