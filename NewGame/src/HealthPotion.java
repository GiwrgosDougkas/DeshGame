import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthPotion extends Player{
	private Health health;
	public HealthPotion(int x, int y,Health health) {
		super(x, y);
		this.id=ID.Health;
		
		// TODO Auto-generated constructor stub
	}
	public void tick() {
		collision();
	}
	@Override
	public void collision() {
		for(GameObject obj: Handler.objects) {
			if(obj.id.equals(ID.Player)) {
			if(getBounds().intersects(obj.getBounds())) {
				
				Health.life+=1;
				Handler.objects.remove(this);
			}
			}
			
		}
		
	}


}
