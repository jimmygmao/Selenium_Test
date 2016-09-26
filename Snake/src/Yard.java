import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Yard extends Frame{
	public static final int LINE=30;//行
	public static final int VERTICAL=30;//列
	public static final int CELL=15;//格子
	
	Snake s=new Snake();
	
	public static void main(String[] args){
		new Yard().PageTable();
	}
	public void PageTable(){
		this.setLocation(600, 200);
		this.setSize(LINE*CELL, VERTICAL*CELL);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillRect(0, 0, LINE * CELL, VERTICAL * CELL);
		for (int i = 1; i < LINE; i++) {
			g.setColor(Color.red);
			g.drawLine(0, CELL * i, VERTICAL * CELL, CELL * i);
		}
		for (int i = 1; i < VERTICAL; i++) {
			g.setColor(Color.red);
			g.drawLine(CELL * i, 0, CELL * i, LINE * CELL);
		}
		g.setColor(c);
		 s.draw(g);
	}
}
