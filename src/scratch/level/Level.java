package scratch.level;

import scratch.graphics.Screen;
import scratch.level.tiles.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
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
	
	//grass = 0x1e9c00
	//flower = 0xFFFF00
	//rock = 0x7F7F00
	
	public Tile getTile(int x, int y) {
		if (!(x < 0 || y < 0 || x >= width || y >= height)) {
			
			if (tiles[x+y*width] == 0xFF1e9c00) return Tile.grass;
			if (tiles[x+y*width] == 0xFFFFFF00) return Tile.flower;
			if (tiles[x+y*width] == 0xFF7F7F00) return Tile.rock;
		}
		return Tile.DefaultTile;
	}
}
