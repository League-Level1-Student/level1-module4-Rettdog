/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MagicBox extends JPanel implements Runnable, MouseListener {
	int scary = 0;
	int girl = 0;
	int water = 0;
	/*
	 * Work together as a TEAM of 2 or 3 to make this project. We are going to hide secrets within the magic box. 
	 * When the user clicks on a secret place, stuff will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (bit.ly/media-palace) to play sounds, show images or speak.
	 * 
	 * 3. backgroundImage.getRGB(keyEvent.getX(), keyEvent.getY()) will give you the color of the current pixel.
	 */

	BufferedImage backgroundImage;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new MagicBox());
	Jukebox box = new Jukebox();
		
		
	}

	@Override
	public void run() {
		try {
			loadBackgroundImage();
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}

	private void createUI() {
		JFrame frame = new JFrame("The Magic Box contains many secrets...");
		frame.add(this);
		frame.addMouseListener(this);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void loadBackgroundImage() throws Exception {
		String imageFile = "src/magic-box.jpg";
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(getDistance(e.getX(),e.getY(),390,358)<20) {
			water++;
		Song fountain = new Song("fountain2.wav");
		fountain.play();
		System.out.println("You can hear water coming out of the fountain");
		}
		if(getDistance(e.getX(),e.getY(),188,867)<18) {
			girl++;
		Song wii = new Song("wii.mp3");
		wii.play();
		System.out.println("She is whistling");
		}
		if(getDistance(e.getX(),e.getY(),195,545)<20) {
		scary++;
		Song spooks = new Song("spookynoise.mp3");
		spooks.play();
		MediaPalace palace = new MediaPalace();
		palace.speak("I am scary");
		}
		if(getDistance(e.getX(),e.getY(),347,644)<10) {
		
			if(water>0&&girl>0&&scary>0) {
				MediaPalace palace = new MediaPalace();
				JFrame frame = new JFrame();
				JLabel image = palace.loadImageFromWithinProject("win.jpg");
				frame.add(image);
				frame.pack();
				frame.setVisible(true);
				
			}
		}
	}
	public double getDistance(int x, int y, int px, int py) {
		int xd = px-x;
		int yd = py-y;
		int xdsq = xd*xd;
		int ydsq = yd*yd;
		
		return Math.sqrt(xdsq+ydsq);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


