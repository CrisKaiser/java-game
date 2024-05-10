package scratch.entity;

import scratch.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	
	public Player(int x, int y ,Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xDir = 0, yDir = 0;
		if (input.up) yDir--;
		if (input.down) yDir++;
		if (input.right) xDir++;
		if (input.left) xDir--;
		
		if (xDir != 0 || yDir != 0) move(xDir, yDir);
	}
	
	public void render() {
		
	}
}
