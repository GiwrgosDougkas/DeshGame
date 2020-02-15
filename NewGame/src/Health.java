import java.awt.Color;
import java.awt.Graphics;

public class Health {
	public static int Health=100;
	private int greenValue=255;
	private int score=0;
	private int level=1;
	public static int life=3;
	
	public void tick() {
		if(greenValue>0) {
		greenValue=Health*2;
			
		}
		if(Health<=0) {
			life--;
			Health=100;
			greenValue=Health*2;
		}
		
		score++;
	}
	public int getHealth() {
		return this.Health;
	}
	public void setScore(int score) {
		this.score=score;
	}
	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(15, 15, 200, 30);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, Health*2, 30);		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 30);//perigrama orthogwnio aspro
		
		g.drawString("Score: " +score, 15, 60);
		g.drawString("Level: "+level,15,80);
		g.drawString("Life: "+life, 15, 100);
	}
	
	public int getScore() {
		return this.score;
	}
	public int getLife() {
		return this.life;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level=level;
	}
	public void setLife(int i) {
		this.life=i;
		
	}
}
