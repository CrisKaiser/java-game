package scratch.entity;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;
import scratch.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	
	public Player(int x, int y ,Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.sprite = Sprite.playerFront0;
	}
	
	public void update() {
		int xDir = 0, yDir = 0;
		if (input.up) yDir--;
		if (input.down) yDir++;
		if (input.right) xDir++;
		if (input.left) xDir--;
		
		if (xDir != 0 || yDir != 0) move(xDir, yDir);
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if (dir == 2) sprite = Sprite.playerFront0;
		if (dir == 4) sprite = Sprite.playerBack0;
		if (dir == 3) sprite = Sprite.playerSide0;
		if (dir == 1) {
			sprite = Sprite.playerSide0;
			flip = 1;
		}
		
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
