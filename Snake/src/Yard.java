import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Yard extends Frame{
	public static final int LINE=50;//行
	public static final int VERTICAL=50;//列
	public static final int CELL=10;//格子
	public static void main(String[] args){
		new Yard().PageTable();
	}
	public void PageTable(){
		this.setLocation(300, 200);
		this.setSize(LINE*CELL, VERTICAL*CELL);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LINE*CELL, VERTICAL*CELL);
		g.setColor(c);
	}
}
