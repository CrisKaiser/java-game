package scratch.level;

import scratch.graphics.Screen;
import scratch.level.tiles.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5; //tileSize = 32
		int x1 = (xScroll + screen.width+32) >> 5;
		int y0 = yScroll >> 5; //tileSize = 32
		int y1 = (yScroll + screen.height+32) >> 5;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (!(x < 0 || y < 0 || x >= width || y >= height)) {
			if (tiles[x+y*width] < 4) return Tile.grass;
			if (tiles[x+y*width] < 6) return Tile.flower;
			if (tiles[x+y*width] <= 8) return Tile.rock;
		}
		return Tile.DefaultTile;
	}
}
