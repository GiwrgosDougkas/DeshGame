import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=650, HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running=false;
	private static Handler handler=null;
	private static Health health=null;
	private static Menu menu=null;
	private static Random r;
	private static Spawn spawn;
	public static  State state=State.Menu;
	
	public Game() {
		addKeyListener(new KeyInput(handler)); 
		addMouseListener(menu);
		new Window(WIDTH,HEIGHT,"Desh",this);
		
		
	}
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		handler=new Handler();
		health=new Health();
		menu=new Menu(handler,health);
		r= new Random();	
		for(int i=0;i<15;i++) {
		handler.addObject(new MenuEnemies(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),10,10,handler));
		}
		
		spawn=new Spawn(handler,health);
		new Game();
		
		
		
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                              
                            }
        }
                stop();
    
		
	}
	private void render() {
		BufferStrategy bs= this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
		}
		else {
			
			Graphics2D g= (Graphics2D) bs.getDrawGraphics();
			
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			handler.render(g);
			
			if(state==State.Game) {
			health.render(g);
			
			}
			else if(state==State.Menu || state==State.End) {
			menu.render(g);
			}
			
			g.dispose();			
			bs.show();
			
			
		}
		
		
	}
	private void tick() {
		handler.tick();
		if(state==State.Game) {
		
		health.tick();
		spawn.tick();
			if(health.getLife()==0) {	
				
				state=State.End;	
				handler.removeAll();
			}
		}
		else if(state==State.End || state==State.Menu) {
			menu.tick();
		}
		
	}
}
