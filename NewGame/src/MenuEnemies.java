import java.awt.Color;
import java.util.Random;

public class MenuEnemies extends Enemy{
	
	
	public MenuEnemies(int x, int y, int width, int height, Handler handler) {
		super(x, y, width, height, handler,new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
		this.velX=2;
		this.velY=7;
	}

}
