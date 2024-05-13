package scratch.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import scratch.level.tiles.Tile;

public class SpawnLevel extends Level{
	
	private int[] levelPixels;
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			levelPixels = new int[w*h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Could not load level!");
		}
	}
	
	//grass = 0x1e9c00
	//flower = 0xFFFF00
	//rock = 0x7F7F00
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0xff1e9c00) tiles[i] = Tile.grass;
			if (levelPixels[i] == 0xffFFFF00) tiles[i] = Tile.flower;
			if (levelPixels[i] == 0xff7F7F00) tiles[i] = Tile.rock;
		}
	}
	
}
