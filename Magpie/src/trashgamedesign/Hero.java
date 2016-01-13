package trashgamedesign;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
//fgjerigu
//sdadasdasasdasd
public class Hero {
	BufferedImage sprite;
	String name;
	int x;
	int y;
	public Hero(String name, String imageLocation, int locationx, int locationy){
		this.name= name;
		int width = 200;
		int height = 200;
		x = locationx;
		y = locationy;
		sprite = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);//"/Images/Heroes/blahsd.png");
		try {
			BufferedImage original = ImageIO.read(url);
			//draws the image gile into a scaled version on
			//the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
			//what to draw 
			//where to start(x,y)
			//width of canvas
			//height of canvas
			//where to start from the original(x,y)
			//width of original,height
			//null
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//gehszhsrth
	}
	public BufferedImage getImage(){
		return sprite;
	}
	public String getName(){
		return name;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void moveUp(){
		y-=10;
	}
	public void moveDown(){
		y+=10;
	}
	public void moveLeft(){
		x-=10;
	}
	public void moveRight(){
		x+=10;
	}
}
