import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {
	public static List<GameObject> objects= new CopyOnWriteArrayList<>();
	
	public void tick() {
		for(GameObject obj :objects) {
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(GameObject obj: objects) {
			obj.render(g);
		}
	}
	public void removeAll() {
		for(GameObject obj: objects) {
			objects.remove(obj);
		}
	}
	
	public void addObject(GameObject obj) {
		
		objects.add(obj);
	}

	public void removeObject(GameObject obj) {
		objects.remove(obj);
	}
	
	public List<GameObject> objects(){
		return this.objects();
	}
	
	public GameObject getPlayer() {
		for(GameObject obj:objects) {
			if(obj.id==ID.Player) {
				return obj;
			}
		}
		return null;
	}
	
	public void getId() {
		for(GameObject obj:objects) {
			System.out.println(obj.id);
		}
		
	}
	
	
}
