import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Yard extends Frame{
	public static final int LINE=30;//行
	public static final int VERTICAL=30;//列
	public static final int CELL=15;//格子
	
	Snake s=new Snake();
	Egg e=new Egg();
	Image OffPictureImage=null;
	
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
		this.addKeyListener(new KeyMonitor());
		new Thread(new PaintThread()).start();
	}

	
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, LINE * CELL, VERTICAL * CELL);
		for (int i = 1; i < LINE; i++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine(0, CELL * i, VERTICAL * CELL, CELL * i);
		}
		for (int i = 1; i < VERTICAL; i++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine(CELL * i, 0, CELL * i, LINE * CELL);
		}
		g.setColor(c);
		s.draw(g);
		e.draw(g);
		s.eat(e);
	}
	
	public void udate(Graphics g){
		if(OffPictureImage==null){
			OffPictureImage=createImage(LINE * CELL, VERTICAL * CELL);
		}
		Graphics gOffScreen=OffPictureImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(OffPictureImage, 0, 0, null);
	}
	
	private class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			s.keyPressed(e);
		}
	}
	
	private class PaintThread implements Runnable{
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
}
