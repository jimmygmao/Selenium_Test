import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TankMoveMsg implements Msg{
	public int id;
	public int x,y;
	public Direction dir;
	public Direction ptDir;
	TankClient tc;
	public int msgType=Msg.TANK_MOVE_MSG;
	public TankMoveMsg(int id, int x,int y,Direction dir,Direction ptDir) {
		this.id = id;
		this.x=x;
		this.y=y;
		this.dir = dir;
		this.ptDir=ptDir;
	}
	public TankMoveMsg(TankClient tc){
		this.tc = tc;
	}
	public void send(DatagramSocket ds, String IP, int udpPort) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(id);
			dos.writeInt(x);
			dos.writeInt(y);
			dos.writeInt(dir.ordinal());//枚举类型的数组的下标值
			dos.writeInt(ptDir.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf=baos.toByteArray();
		try {
			DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress(IP,udpPort));
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parse(DataInputStream dis) {
		try {
			int id=dis.readInt();
			/**
			 * 如果存在这个坦克，则退出
			 */
			if(tc.myTank.id==id){
				return;
			}
			int x=dis.readInt();
			int y=dis.readInt();
			Direction dir=Direction.values()[dis.readInt()];
			Direction prDir=Direction.values()[dis.readInt()];
			//如果存在这个坦克,则将新的dir赋予它
			for(int i=0;i<tc.tanks.size();i++){
				Tank t=tc.tanks.get(i);
				if(t.id==id){//如果存在这个坦克
					t.x=x;
					t.y=y;
					t.ptDir=prDir;
					t.dir=dir;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

