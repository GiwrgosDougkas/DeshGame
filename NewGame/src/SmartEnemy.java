import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SmartEnemy extends Enemy{
	private GameObject player;
	private Handler handler;
	public SmartEnemy(int x, int y, int width, int height, Handler handler, Color c) {
		super(x, y, width, height, handler, c);
		// TODO Auto-generated constructor stub
		
		this.handler=handler;
		player=handler.getPlayer();
	}
	
	public void tick() {
		this.x+=velX;
		this.y+=velY;
		double diffX=x-player.x-32;
		double diffY=y-player.y-32;
		double distance= Point2D.distance(this.x, this.y, player.x, player.y);
		this.velX =  ((-1/distance) * diffX);
		this.velY =  ((-1/distance) * diffY);
		
		
		handler.addObject(new Trail(x,y,width,height,c,handler, 0.1f));
	}
}
