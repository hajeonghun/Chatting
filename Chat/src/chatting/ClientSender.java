//package chatting;
//
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.util.Scanner;
//
//class ClientSender extends Thread {
//	Socket socket = null;
//	Socket outsocket = null;
//	DataOutputStream out;
//	OutputStream outputStream;
//	InetAddress ip;
//	int port;
//	String name;
//
//	ClientSender(Socket socket, String name) {
//		this.socket = socket;
//		try {
//			outputStream = socket.getOutputStream();
//			out = new DataOutputStream(outputStream);
//			ip = socket.getInetAddress();
//			port = socket.getPort();
//			this.name = name;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void run() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			if (out != null) {
//				out.writeUTF(name + " 님이 접속하셨습니다.");
//			}
//			while (out != null) {
//				// out.writeUTF("["+name+"]"+scanner.nextLine());
//
//				String s = scanner.nextLine();
//				byte[] b = s.getBytes("UTF-8");
//				out.write(b);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//}

package chatting;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class ClientSender {
	Socket socket = null;
	Socket outsocket = null;
	DataOutputStream out;
	OutputStream outputStream;
	InetAddress ip;
	int port;
	String name;

	ClientSender(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
		System.out.println("이름 = "+ name);
		try {
			outputStream = socket.getOutputStream();
			out = new DataOutputStream(outputStream);
			ip = socket.getInetAddress();
			port = socket.getPort();
			out.writeUTF(name + " 님이 접속하셨습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String log) {
		try {
			// out.writeUTF("["+name+"]"+scanner.nextLine());

			String s = log;
			byte[] b = s.getBytes("UTF-8");
			out.write(b);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}