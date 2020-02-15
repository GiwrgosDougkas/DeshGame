import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keydown=new boolean[4];
	public KeyInput(Handler anObject) {
		this.handler=anObject;
		this.keydown[0]=false;
		this.keydown[1]=false;
		this.keydown[2]=false;
		this.keydown[3]=false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		for(GameObject object: handler.objects) {
			if(object.id.equals(ID.Player)) {
			if( key== KeyEvent.VK_D || key==KeyEvent.VK_RIGHT)
			{
				object.setvelX(5);
				this.keydown[0]=true;
				
			}
			if( key== KeyEvent.VK_A || key==KeyEvent.VK_LEFT)
			{
				object.setvelX(-5);
				this.keydown[1]=true;
			}
			if( key== KeyEvent.VK_W|| key==KeyEvent.VK_UP)
			{
				object.setvelY(-5);
				this.keydown[2]=true;
			}
			if( key== KeyEvent.VK_S|| key==KeyEvent.VK_DOWN)
			{
				object.setvelY(+5);
				this.keydown[3]=true;
			}
			}
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key= e.getKeyCode();
		if(key==KeyEvent.VK_ESCAPE) { System.exit(1);}
		if(key==KeyEvent.VK_ESCAPE && (Game.state==State.Game || Game.state==State.Menu)) {Game.state=State.Menu;}
		for(GameObject object: handler.objects) {
			
			if(object.id==ID.Player) {
			
			if( key== KeyEvent.VK_D || key==KeyEvent.VK_RIGHT)
			{
				//object.setvelX(0);
				keydown[0]=false;
			}
			if( key== KeyEvent.VK_A || key==KeyEvent.VK_LEFT)
			{
				keydown[1]=false;
				//object.setvelX(0);
			}
			if( key== KeyEvent.VK_W|| key==KeyEvent.VK_UP)
			{
				keydown[2]=false;
				//object.setvelY(0);
			}
			if( key== KeyEvent.VK_S|| key==KeyEvent.VK_DOWN)
			{
				keydown[3]=false;
				//object.setvelY(0);
			}
			
			if(!keydown[0] && !keydown[1]) {
				object.setvelX(0);
			}			
			if(!keydown[2] && !keydown[3]) {
				object.setvelY(0);
			}
			
			}
		}
	}
}
