import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
/**
 * 建立TCP的监听、建立UDP的监听
 * 服务器端接受数据到客户端，并发送到其他客户端
 * @author lenovo
 *
 */
public class TankServer {
	private static int ID=100;
	public static final int TCP_PORT=8888;
	public static final int UDP_PORT=6666;	
	
	List<Client> clients =new ArrayList<Client>();//加入多少客户端
	
	public static void main(String[] args){
		new TankServer().start();//启动Server
	}
	/**
	 * 启动UDP线程，把主线程当做TCP来使用
	 */
	public void start(){
		new Thread(new UDPThread()).start();//启动UDP的线程
		ServerSocket ss=null;
		try {
			ss=new ServerSocket(TCP_PORT);//把主线程当做TCP来使用
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			Socket s=null;
			try {
				s=ss.accept();//在TCP首先接受客户端的连接
				DataInputStream dis=new DataInputStream(s.getInputStream());
				int udpPort=dis.readInt();
				String IP=s.getInetAddress().getHostAddress();
				Client c=new Client(IP,udpPort);//把将来要使用的UDP的IP、端口号传递进来
				clients.add(c);
				System.out.println("A Client Connect! Addr- "+s.getInetAddress()+":"+s.getPort()+"----UDP Port"+udpPort);
				DataOutputStream dos=new DataOutputStream(s.getOutputStream());
				dos.writeInt(ID++);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(s!=null){
					try {
						s.close();
						s=null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	/**
	 * 保存UDP的IP、端口
	 * @author lenovo
	 *
	 */
	public class Client{
		String IP;
		int udpPort;//保留UDP端口号
		public Client(String IP,int udpPort){
			this.IP=IP;
			this.udpPort=udpPort;
		}
	}
	/**
	 * 因为保存好了UDP的IP、端口，所以启动UDP的线程
	 * @author lenovo
	 *
	 */
	private class UDPThread implements Runnable{
		/**
		 * 服务器端获取客户端数据
		 */	
		byte[] buf=new byte[1024];//装数据
		public void run() {
			DatagramSocket ds=null;
			try {
				ds=new DatagramSocket(UDP_PORT);
			} catch (SocketException e) {
				e.printStackTrace();
			}
			while(ds!=null){
				DatagramPacket dp=new DatagramPacket(buf,buf.length);//new一个包袱装数据
				try {
					ds.receive(dp);//拿到数据
					for(int i=0;i<clients.size();i++){
						Client c=clients.get(i);
						dp.setSocketAddress(new InetSocketAddress(c.IP,c.udpPort));//把这包数据根据地址发送出去
						ds.send(dp);//发送
					}
					//System.out.println("从客户端拿到数据");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
