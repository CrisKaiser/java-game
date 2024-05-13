package scratch.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(32, 7, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(32, 6, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(32, 5, 0, SpriteSheet.tiles);
	public static Sprite DefaultSprite = new Sprite(32, 0x000000);
	
	
	public static Sprite playerFront0 = new Sprite(32, 0, 0, SpriteSheet.tiles);
	public static Sprite playerFront1 = new Sprite(32, 1, 0, SpriteSheet.tiles);
	public static Sprite playerFront2 = new Sprite(32, 2, 0, SpriteSheet.tiles);
	public static Sprite playerFront3 = new Sprite(32, 3, 0, SpriteSheet.tiles);
	
	public static Sprite playerSide0 = new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite playerSide1 = new Sprite(32, 1, 1, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 2, 1, SpriteSheet.tiles);
	public static Sprite playerSide3 = new Sprite(32, 3, 1, SpriteSheet.tiles);
	
	public static Sprite playerBack0 = new Sprite(32, 0, 3, SpriteSheet.tiles);
	public static Sprite playerBack1 = new Sprite(32, 1, 3, SpriteSheet.tiles);
	public static Sprite playerBack2 = new Sprite(32, 2, 3, SpriteSheet.tiles);
	public static Sprite playerBack3 = new Sprite(32, 3, 3, SpriteSheet.tiles);
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x)+(y+this.y)*sheet.SIZE];
			}
		}
	}
}
