package scratch.level.tiles;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;

public class DefaultTile extends Tile {
	public DefaultTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<5, y<<5, this);
	}
}