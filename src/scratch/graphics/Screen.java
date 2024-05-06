package scratch.graphics;

import java.util.Iterator;
import java.util.Random;

public class Screen {
	
	private int width;
	private int height;
	public int[] pixels;
	
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; //->8*8 different tiles
	
	private final int tileControl = 4;
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for (int y=0; y < height; y++) {
			int yy = y + yOffset;
			for (int x = 0; x < width; x++) {
				int xx = x + xOffset;
				int tileIndex = ((xx>>tileControl)&MAP_SIZE_MASK)+((yy>>tileControl)&MAP_SIZE_MASK)*MAP_SIZE; 
				pixels[x+y*width] = tiles[tileIndex];
			}
		}
	}
}