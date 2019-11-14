package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���Ͷ�
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
			//׼����������װ��DatagramPacket����
			byte[] datas=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
			//����ʽ���հ���
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
