package scratch.graphics;

import java.util.Iterator;
import java.util.Random;

import scratch.entity.Player;
import scratch.level.tiles.Tile;

public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; //->8*8 different tiles
	
	public int xOffset, yOffset;
	
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

	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				{
					if (xa < 0 - tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
					if (xa < 0) xa = 0;
					pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				}
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				{
					if (xa < 0 - 32 || xa >= width || ya < 0 || ya >= height) break;
					if (xa < 0) xa = 0;
					int color = sprite.pixels[x + y * 32];
					if (color != 0x000000) {
						pixels[xa+ya*width] = color;
					}
					
				}
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
