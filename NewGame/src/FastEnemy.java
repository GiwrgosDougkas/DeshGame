import java.awt.Color;

public class FastEnemy extends Enemy{

	public FastEnemy(int x, int y, int width, int height, Handler handler, Color c) {
		super(x, y, width, height, handler, c);
		// TODO Auto-generated constructor stub
		this.velX=2;
		this.velY=8;
		
	}
	
}
