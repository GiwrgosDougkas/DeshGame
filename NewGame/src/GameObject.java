import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x,y;
	protected ID id;
	protected double velX,velY;
	
	public GameObject(int x, int y, ID id) {
		this.x=x;
		this.y=y;
		this.id=id;		
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getY() {
		return this.y;
	}
	public void setvelX(int x) {
		this.velX=x;
	}
	public double getvelX() {
		return this.velX;
	}
	
	public void setvelY(int y) {
		this.velY=y;
	}
	public double getvelY() {
		return this.velY;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
}
