package scratch.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		System.out.println(path);
		load();
		
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(new File("rsc/textures/spritesheet.png"));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0,  0, w, h, pixels, 0, w);
			System.out.println("loading succeeded");
		}catch(IOException e) {
			System.out.println("loading failed");
			e.printStackTrace();
		}
		
	}
}
