import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	private float alpha=1;
	private float life;
	private int width,height;
	private Handler handler;
	private Color c;
	public Trail(int x,int y,int widht,int height,Color c,Handler handler,float life) {
		super(x,y,ID.Trail);		
		this.width=height;
		this.height=width;
		this.c=c;
		this.handler=handler;
		this.life=life;
	}	
	
	@Override
	public void tick() {		
		
		
		if(alpha>life) {
			alpha-=0.05;
		}
		else {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D ga= (Graphics2D)g;
		ga.setComposite(makeTransparent(alpha));
		ga.setColor(c);
		ga.fillRect(x, y, width, height);
		
		ga.setComposite(makeTransparent(1));
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	private AlphaComposite makeTransparent(float alpha) {
		int type=AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type,alpha);
	}
	
	

}
