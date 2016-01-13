package trashgamedesign;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyTrash extends JFrame implements KeyListener{

	int width = 500;
	int height = 500;
	Hero happyfeet;
	Hero squirrel;
	BufferedImage landscape;
	boolean itemPickedUp = false;
	
	public static void main(String[] args) {
		new MyTrash();
	}
	public MyTrash(){
		//the following are JFrame methods
		happyfeet = new Hero("happy","/Images/Heroes/blahsd.png",200,200);
		squirrel = new Hero("squirrel","/Images/Heroes/squirrel.jpeg",0,0);
		landscape = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		setVisible(true);
		setSize(width,height); //500 by 500 pixels
		setLocation(200,150); // 200 down by 150 right
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //static constant reference for special close operation
		addKeyListener(this);
		
	}
	private void paintLandscape(Graphics2D g2){
		int squareD = 20;
		int margin = 2;
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i=0;i<width;i+=squareD+margin){
			for(int j=0;j<height;j+=squareD+margin){
				g2.setColor(new Color(a,b,c));
				a = (int)(Math.random()*256);
				b = (int)(Math.random()*256);
				c = (int)(Math.random()*256);
				g2.fillRect(i, j, squareD, squareD);
			}

		}
	}
	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2D is like an art kit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		g2.setColor(Color.CYAN);
		g2.drawImage(landscape,0,0,null);
		g2.fillRect(0, 0, width, height);
//		g2.setColor(Color.pink);
//		g2.drawOval(100, 100, 200, 200);
//
//		g2.fillOval(100,100,150,300);
		//x,y,width,height, startDEG, lengthDEG
//		g2.setColor(Color.green);
//		g2.drawArc(50, 300, 100, 100, 180, 180);
//		g2.drawString("Strings are drawn like this",300,300);
//		g2.drawLine(0,0,width,height);
//		g2.fillRect(100,100,200,200);
//		g2.setColor(Color.black);
//		g2.fillRect(150,150,30,30);
//		g2.fillRect(210, 150, 30, 30);
//		g2.fillRect(210, 150, 30, 30);
//		int squareD = 20;
//		int margin = 2;
//		int a = 0;
//		int b = 0;
//		int c = 0;
//		for(int i=0;i<width;i+=squareD+margin){
//			for(int j=0;j<height;j+=squareD+margin){
//				g2.setColor(new Color(a,b,c));
//				a = (int)(Math.random()*256);
//				b = (int)(Math.random()*256);
//				c = (int)(Math.random()*256);
//				g2.fillRect(i, j, squareD, squareD);
//			}
//
//		}
		//		//draw the bufferedimage on the canvas
		//		g2.drawArc(125, 225, 200, 200, 90, 180);
		//		g2.drawArc(125, 100, 200, 200, 270, 180);

		g.drawImage(image,0,0,null);
		//happyfeet = new Hero("happy","/Images/Heroes/blahsd.png",200,200);
		g.drawImage(happyfeet.getImage(),happyfeet.getX(),happyfeet.getY(),null);
		//squirrel = new Hero("squirrel","/Images/Heroes/squirrel.jpeg",200,200);
		if(!itemPickedUp)
		g.drawImage(squirrel.getImage(),squirrel.getX(),squirrel.getY(),null);
		if(Math.abs(happyfeet.getX())+Math.abs(squirrel.getX())<4){
			itemPickedUp = true;
		}
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			happyfeet.moveUp();
		}
		if(key == KeyEvent.VK_DOWN){
			happyfeet.moveDown();
		}
		if(key == KeyEvent.VK_LEFT){
			happyfeet.moveLeft();
		}
		if(key == KeyEvent.VK_RIGHT){
			happyfeet.moveRight();
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
