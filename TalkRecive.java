package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 发送端
 * @author dell
 *
 */

public class TalkRecive implements Runnable {
	private DatagramSocket server;
	private int port;
	public TalkRecive(int port) {
		super();
		try {
			this.server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while(true) {
			//准备容器，封装成DatagramPacket包裹
			byte[] datas=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
			//阻塞式接收包裹
			try {
				server.receive(packet);
				String str=new String(packet.getData(),0,packet.getLength());
				System.out.println(str);
				if(str.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.server.close();
	}
	

}
