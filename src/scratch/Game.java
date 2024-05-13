package scratch;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import scratch.entity.Player;
import scratch.graphics.Screen;
import scratch.input.Keyboard;
import scratch.level.Level;
import scratch.level.RandomLevel;
import scratch.level.SpawnLevel;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private final double LOGIC_UPDATE_RATE = 60.0;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;
	
	private Level level = new SpawnLevel("res/textures/levelmap.png");
	private Player player;
	private Screen screen;
	
	
	public static String title = "Scratch";
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); //converting image to int[]
	
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		this.screen = new Screen(width, height);
		this.frame = new JFrame();
		this.key = new Keyboard();
		this.player = new Player(key);
		
		addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / LOGIC_UPDATE_RATE; 
		double delta = 0.0;
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1.0) {
				update();
				delta = 0.0;
				updates++;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + String.valueOf(frames) + " fps");
				frames = 0;
			}
		}
		
		
	}
	

	public void update() {
		key.update();
		player.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0,0,getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Font", 0, 50));
		g.drawString(String.valueOf(player.x) +  " : " + String.valueOf(player.y), 450, 400);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);  //-> Game inherits from Canvas
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
