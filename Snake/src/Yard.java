import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Yard extends Frame{
	PaintThread paintThread=new PaintThread();
	public static final int LINE=30;//行
	public static final int VERTICAL=30;//列
	public static final int CELL=15;//格子
	
	Snake s=new Snake(this);
	Egg e=new Egg();
	
	Image OffPictureImage=null;
	
	private boolean gameOver=false;
	private Font FontGameOver=new Font("宋体",Font.BOLD,50);
	private int score=0;
	public int getscore() {
		return score;
	}
	public void setscore(int score) {
		this.score = score;
	}


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
		new Thread(paintThread).start();
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
		g.setColor(Color.YELLOW);
		g.drawString("分数："+score, 10, 60);
		if(gameOver){
			g.setFont(FontGameOver);
			g.drawString("game over", 100, 250);
			paintThread.pause();
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
	
	public void stop(){
		gameOver=true;
	}
	
	private class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			if(key==KeyEvent.VK_F2){
				paintThread.reStart();
			}
			s.keyPressed(e);
		}
	}
	
	private class PaintThread implements Runnable{
		private boolean runing=true;
		private boolean pause = false;
		public void run() {
			while(runing){
				if(pause){
					continue;
				}else{
					repaint();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
		public void pause() {
			pause = true;
		}
		public void reStart(){
			pause=false;
			s=new Snake(Yard.this);
			gameOver=false;
		}
	}
}
