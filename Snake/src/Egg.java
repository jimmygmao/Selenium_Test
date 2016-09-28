import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
public class Egg {
	int row;
	int col;
	int w=Yard.CELL;
	int h=Yard.CELL;
	private Color color=Color.GREEN;
	
	private static Random r=new Random();//随机数产生器，整数
	public Egg(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Egg(){
		this(r.nextInt(Yard.LINE-2)+2,r.nextInt(Yard.VERTICAL-2)+2);
	}
	public void reAppear(){
		this.row=r.nextInt(Yard.LINE-2)+2;
		this.col=r.nextInt(Yard.VERTICAL-2)+2;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(Yard.CELL * col, Yard.CELL * row, w, h);
		g.setColor(c);
		if(color==Color.GREEN){
			color=Color.RED;
		}else{
			color=Color.GREEN;
		}
	}
	public Rectangle getRevt(){
		return new Rectangle(Yard.CELL * col, Yard.CELL * row, w, h); 	
	}
}
