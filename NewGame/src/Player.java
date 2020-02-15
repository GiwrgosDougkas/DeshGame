import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player extends GameObject{
	
	public Player(int x, int y) {
		super(x,y,ID.Player);
	}
	@Override
	public void tick() {
		this.x+=velX;
		this.y+=velY;
		
		if( y>= Game.HEIGHT-60) {
			y=Game.HEIGHT-60;
		}
		if(y<=0) {
			y=0;
		}
		if(x>=Game.WIDTH-36) {
			x=Game.WIDTH-36;
		}
		
		if(x<=0) {
			x=0;
		}
		collision();
	}

	public void collision() {
		for(GameObject obj: Handler.objects) {
			if(obj.id.equals(ID.Enemy)) {
			if(getBounds().intersects(obj.getBounds())) {
				Health.Health-=2;
			}
			}
			
		}
		
	}
	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, y, 30, 30);
		
		
	}
	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,30,30);
	}

}
