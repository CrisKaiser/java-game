package scratch.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import scratch.level.tiles.Tile;

public class SpawnLevel extends Level{	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			int w = width =  image.getWidth();
			int h = height =  image.getHeight();
			tiles = new int[w*h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Could not load level!");
		}
	}
	
	
	protected void generateLevel() {
		
	}
	
}
