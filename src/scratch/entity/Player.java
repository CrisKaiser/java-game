package scratch.entity;

import scratch.graphics.Screen;
import scratch.graphics.Sprite;
import scratch.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
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
		
		if (anim < 10000) anim++;
		else anim = 0;
		
		if (input.up) yDir--;
		if (input.down) yDir++;
		if (input.right) xDir++;
		if (input.left) xDir--;
		
		if (xDir != 0 || yDir != 0) {
			move(xDir, yDir);
			walking = true;
		}else {
			walking = false;
		}
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if (dir == 2) {
			sprite = Sprite.playerFront0;
			if (walking) {
				if (anim % 30 < 10) {
					sprite = Sprite.playerFront1;
				}else if(anim % 30 < 20) {
					sprite = Sprite.playerFront2;
				}else {
					sprite = Sprite.playerFront3;
				}
			}
		}
		if (dir == 4) {
			sprite = Sprite.playerBack0;
			if (walking) {
				if (anim % 30 < 10) {
					sprite = Sprite.playerBack1;
				}else if(anim % 30 < 20) {
					sprite = Sprite.playerBack2;
				}else {
					sprite = Sprite.playerBack3;
				}
			}
		}
		if (dir == 3 || dir == 1) {
			sprite = Sprite.playerSide0;
			if (walking) {
				if (anim % 30 < 10) {
					sprite = Sprite.playerSide1;
				}else if(anim % 30 < 20) {
					sprite = Sprite.playerSide2;
				}else {
					sprite = Sprite.playerSide3;
				}
			}
		}
		if (dir == 1) {
			flip = 1;
		}
		
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
