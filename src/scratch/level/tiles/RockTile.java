package scratch.level.tiles;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<5, y<<5, this);
	}
	
	public boolean solid() {
		return true;
	}

}
