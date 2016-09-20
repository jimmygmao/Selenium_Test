import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * 客户端发送数据到服务器端，并接受回来
 * @author lenovo
 *
 */
public class NetClient {
	public int udpPort;

	TankClient tc;
	
	DatagramSocket ds=null;
	
	public String IP;
	
	public void setUdpPort(int udpPort) {
		this.udpPort = udpPort;
	}
	
	public NetClient(TankClient tc){
		this.tc=tc;
	}
	/**
	 * 连接到服务器
	 * @param IP
	 * @param port
	 */
	public void connect(String IP,int port){
		this.IP=IP;
		try {
			ds=new DatagramSocket(udpPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		Socket s=null;
		try {
			s=new Socket(IP,port);
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			int id=dis.readInt();
			tc.myTank.id=id;
			if(id%2==0){
				tc.myTank.setGood(false);
			}else{
				tc.myTank.setGood(true);
			}
			System.out.println("客户端连接到服务器");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				s=null;
			}	
		}
		/**
		 * 坦克第一次连上
		 * UDP发送坦克的数据
		 */
		TankNewMsg msg=new TankNewMsg(tc.myTank);	
		send(msg);
		new Thread(new UDPpecvThread()).start();
	}
	/**
	 * 客户端获取坦克的数据
	 * @param msg
	 */
	public void send(Msg msg){
		msg.send(ds,IP,TankServer.UDP_PORT);
	}
	/**
	 * 客户端获取服务器的数据
	 * @author lenovo
	 *
	 */
	private class UDPpecvThread implements Runnable{
		byte[] buf=new byte[1024];
		public void run() {
			System.out.println("线程启动成功");
			while(ds!=null){
				DatagramPacket dp=new DatagramPacket(buf,buf.length);//new一个包袱装数据
				try {
					ds.receive(dp);//拿到数据
				//	System.out.println("从Server拿到数据");
					parse(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 解析消息
		 * @param dp
		 */
		private void parse(DatagramPacket dp){

			ByteArrayInputStream bais=new ByteArrayInputStream(buf,0,dp.getLength());
			DataInputStream dis=new DataInputStream(bais);
			int msgType=0;
			try {
				msgType=dis.readInt();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Msg msg=null;
			switch(msgType){
			case Msg.TANK_NEW_MSG:
				msg=new TankNewMsg(NetClient.this.tc);//NetClient.this.tc内部类访问类里面的对象
				msg.parse(dis);
				break;
			case Msg.TANK_MOVE_MSG:
				msg=new TankMoveMsg(NetClient.this.tc);//NetClient.this.tc内部类访问类里面的对象
				msg.parse(dis);
				break;
			case Msg.MISSILE_MOVE_MSG:
				msg=new MissileNewMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			case Msg.TANK_DEAD_MSG:
				msg=new TankDeadMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			case Msg.MISSILE_DEAD_MSG:
				msg=new MissileDeadMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			}
		}
	}
}
