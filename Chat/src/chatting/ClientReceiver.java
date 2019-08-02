package chatting;


import java.io.DataInputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class ClientReceiver extends Thread {
	Socket socket;
	DataInputStream in;
	String str;
	ChattingClient chattingClient;
	
	ClientReceiver(Socket socket, ChattingClient chattingClient) {
		this.socket = socket;
		this.chattingClient = chattingClient;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		byte[] by = new byte[0];
		int i = 0;
		boolean isFirstTime = true;
		while (in != null) {

			try {
				while (in.available() > 0) {
					if(isFirstTime) {
						by= new byte[in.available()];
						isFirstTime=false;
					}
					
					by[i++] = in.readByte();
				}
				if(i>0){
					str = new String(by, StandardCharsets.UTF_8);
//					System.out.println(str);
					chattingClient.getLog(str);
				}
				// 227 133 129
			} catch (Exception e) {
				// e.printStackTrace();
			} finally {
				i = 0;
				isFirstTime=true;
			}
		}
	}
}