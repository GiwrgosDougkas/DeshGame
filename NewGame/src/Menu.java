import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{
	private int x,y;
	private int velX,velY;
	private Health health;
	private Random r=new Random();
	private Handler handler;
	public Menu(Handler handler,Health health) {
		this.handler=handler;
		this.health=health;
		velX=2;
		velY=9;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int nx=e.getX();
		int ny=e.getY();
		//playbutton
		if(Game.state==State.Menu) {
			if(mouseOver(nx,ny,230, 150, 200, 50)) {
				Game.state=State.Game;
				Handler.objects.clear();
				Handler.objects.add(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),10,10,handler,Color.red));
				Handler.objects.add(new Player(140,150));
			}
			if(mouseOver(nx,ny,230, 250, 200, 50)) {
				Game.state=State.Help;
				
			}
			//quit button
			if(mouseOver(nx,ny,230, 350, 200, 50)) {
				System.exit(1);
			}
		}
		 if(Game.state==State.Help) {
			if(mouseOver(nx,ny,230, 350, 200, 50)) {
				Game.state=State.Menu;
			}
		}
		 if(Game.state==State.End) {
			if(mouseOver(nx,ny,230, 350, 200, 50)) {
				Game.state=State.Game;
				health.setLevel(1);
				health.setScore(0);
				health.setLife(3);
				
				Handler.objects.clear();				
				Handler.objects.add(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),10,10,handler,Color.red));
				Handler.objects.add(new Player(140,150));
			}
		}
	}
	private boolean mouseOver(int nx,int ny, int x, int y,int width, int height) {
		if(nx>x && nx<x+width) {
			if(ny>y && ny<y+height) {
				return true;
			}
		}
			return false;
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
	}
	
	public void render(Graphics g) {
		
		if(Game.state==State.Menu) {
			
			
		g.setFont(new Font("arial",1,40));
		g.setColor(Color.white);
		g.drawString("Menu", 280, 40);
		g.setFont(new Font("arial",1,25));
		
		g.drawString("Play", 300, 185);
		g.drawRect(230, 150, 200, 50);
		
		g.drawString("Help", 300, 285);			
		g.drawRect(230, 250, 200, 50);
			
		g.drawString("Quit", 300, 385);
		g.drawRect(230, 350, 200, 50);
		}
		else if(Game.state==State.Help) {
			g.setColor(Color.white);
			g.setFont(new Font("arial",1,20));
			g.drawString("Use A,D,W,S or arrows to move and dodge the enemies", 70, 150);
			g.setFont(new Font("arial",1,30));
			g.drawString("Back", 300, 385);
			g.drawRect(230, 350, 200, 50);
		}
		else if(Game.state==State.End) {
			g.setColor(Color.white);
			g.setFont(new Font("arial",1,20));
			g.drawString("Your score is: "+health.getScore(), 70, 150);
			g.setFont(new Font("arial",1,30));
			g.drawString("Try Again", 280, 385);
			g.drawRect(250, 350, 200, 50);
		}
	} 
}
