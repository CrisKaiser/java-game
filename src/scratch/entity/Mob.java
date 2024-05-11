package scratch.entity;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xDir, int yDir) {
		if (xDir > 0) dir = 1;
		if (xDir < 0) dir = 3;
		if (yDir > 0) dir = 2;
		if (yDir < 0) dir = 4;
		
		if (!collision()) {
			x += xDir;
			y += yDir;
		}
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		screen.renderPlayer(x,  y,  Sprite.playerFront0);
	}
	
	private boolean collision() {
		return false;
	}
	
	
}
