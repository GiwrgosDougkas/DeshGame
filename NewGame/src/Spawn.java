import java.awt.Color;
import java.util.Random;

public class Spawn {
	private Random s=new Random();
	private Handler handler;
	private Health health;
	private int counter;

	public Spawn(Handler handler, Health health) {
		this.handler=handler;
		this.health=health;
	}
	
	public void tick() {
		counter++;
		if(counter>100) {
			counter=0;
		
			health.setLevel(health.getLevel()+1);
			//handler.addObject(new Enemy(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),10,10,handler,Color.red));
			if( health.getLevel()<=10) {
				//handler.addObject(new Enemy(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),10,10,handler,Color.red));
				handler.addObject(new FastEnemy(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),10,10,handler,Color.CYAN));
			}
			if(health.getLevel()==5) {
				handler.addObject(new Enemy(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),30,30,handler,Color.blue));
				handler.addObject(new HealthPotion(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),health));
			}
			if(health.getLevel()==6) {
				handler.addObject(new SmartEnemy(s.nextInt(Game.WIDTH),s.nextInt(Game.HEIGHT),15,15,handler,Color.ORANGE));
			}
		}
		
		
	}
	
}
