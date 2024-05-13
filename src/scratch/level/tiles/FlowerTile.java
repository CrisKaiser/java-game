package scratch.level.tiles;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<5, y<<5, this);
	}
	
}
