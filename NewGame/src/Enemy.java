import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{
	private Handler handler;
	protected int width,height;
	protected Color c;
	public Enemy(int x,int y, int width, int height, Handler handler,Color c) {
		super(x,y,ID.Enemy);
		velX=2;
		velY=2;
		this.width=width;
		this.height=height;
		this.handler=handler;
		this.c=c;
	}
	
	@Override
	public void tick() {
		this.x+=velX;
		this.y+=velY;
		if(y<=0 || y>=Game.HEIGHT -37 ) {
			velY*=-1;
		}
		if(x<=0 || x>=Game.WIDTH -10 ) {
			velX*=-1;
		}
		handler.addObject(new Trail(x,y,width,height,c,handler, 0.1f));
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

}
