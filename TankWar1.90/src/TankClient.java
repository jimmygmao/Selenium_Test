import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankClient extends Frame {
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	NetClient nc=new NetClient(this);
	ConnDialog dialos=new ConnDialog();
	Tank myTank = new Tank(50, 50, true, Direction.STOP, this);
	
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	
	
	Image offScreenImage = null;
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	
	public void launchFrame() {
		
/*		for(int i=0; i<10; i++) {
			tanks.add(new Tank(50 + 40*(i+1), 50, false, Direction.D, this));
		}*/
		
		this.setLocation(400, 300);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		
		this.addKeyListener(new KeyMonitor());
		
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	class KeyMonitor extends KeyAdapter {

		public void keyReleased(KeyEvent e) {  
				myTank.keyReleased(e);

		}

		public void keyPressed(KeyEvent e) {
			int Key=e.getKeyCode();
			if(Key==KeyEvent.VK_C){
				dialos.setVisible(true);
			}else{
			myTank.keyPressed(e);
			}
		}
	}
	class PaintThread implements Runnable {

		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void paint(Graphics g) {
		g.drawString("missiles count:" + missiles.size(), 10, 50);
		g.drawString("explodes count:" + explodes.size(), 10, 70);
		g.drawString("tanks    count:" + tanks.size(), 10, 90);
		
		for(int i=0; i<missiles.size(); i++) {
			Missile m = missiles.get(i);
			if(m.hitTank(myTank)){
				TankDeadMsg msg=new TankDeadMsg(myTank.id);
				nc.send(msg);
				MissileDeadMsg mdmmsg=new MissileDeadMsg(m.tankId,m.id);
				nc.send(mdmmsg);
			}
			m.draw(g);
		}
		
		for(int i=0; i<explodes.size(); i++) {
			Explode e = explodes.get(i);
			e.draw(g);
		}
	
		for(int i=0; i<tanks.size(); i++) {
			Tank t = tanks.get(i);
			t.draw(g);
		}
		myTank.draw(g);
	}

	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(800, 600);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	/**
	 * 把IP、TCP、DUP传过去
	 * @author lenovo
	 *
	 */
	class ConnDialog extends Dialog{
		Button bqd=new Button("确定");
		TextField tIP=new TextField("127.0.0.1",12);
		TextField tP=new TextField(""+TankServer.TCP_PORT,4);
		TextField tuDP=new TextField("2223",4);
		public ConnDialog() {
			super(TankClient.this, true);
			this.setLayout(new FlowLayout());
			this.add(new Label("IP:"));
			this.add(tIP);
			this.add(new Label("Port:"));
			this.add(tP);
			this.add(new Label("My UDP Port:"));
			this.add(tuDP);
			this.add(bqd);
			this.setLocation(500, 500);
			this.pack();
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					setVisible(false);
				}
			});
			bqd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String IP=tIP.getText().trim();
					int port=Integer.parseInt(tP.getText().trim());
					int uDP=Integer.parseInt(tuDP.getText().trim());
					nc.setUdpPort(uDP);
					nc.connect(IP, port);
					setVisible(false);
				}
			});
		}
	}
}
