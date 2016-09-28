import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
public class Egg {
	int row;
	int col;
	int w=Yard.CELL;
	int h=Yard.CELL;
	private static Random r=new Random();//随机数产生器，整数
	public Egg(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Egg(){
		this(r.nextInt(Yard.LINE-3)+3,r.nextInt(Yard.VERTICAL-3)+3);
	}
	public void reAppear(){
		this.row=r.nextInt(Yard.LINE-3)+3;
		this.col=r.nextInt(Yard.VERTICAL-3)+3;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillOval(Yard.CELL * col, Yard.CELL * row, w, h);
		g.setColor(c);
	}
	public Rectangle getRevt(){
		return new Rectangle(Yard.CELL * col, Yard.CELL * row, w, h); 	
	}
}
