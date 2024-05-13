package scratch.level.tiles;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile DefaultTile = new DefaultTile(Sprite.DefaultSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) { //substitution
	}
	
	public boolean solid() {
		return false;
	}
}
