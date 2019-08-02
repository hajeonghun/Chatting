package chatting;
import java.net.ConnectException;
import java.net.Socket;

class ChattingClient {

	String ip ; // 입력해주고

	String name = "";
	int socket;
	ClientSender clientSender;
	ClientReceiver clientReceiver;
	Controller controller;
	public ChattingClient(String name, String ip, int socket, Controller controller) {
		
		nameCheck(name);
		this.ip = ip;
		this.socket = socket;
		this.controller = controller;
		System.out.println("4이름 = "+this.name);
		try {
			Socket s = new Socket(this.ip, this.socket);
			System.out.println("Server Connect!");
			clientSender = new ClientSender(s, name);
			clientReceiver = new ClientReceiver(s, this);
			Thread receiver = new Thread(clientReceiver);

			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void nameCheck(String name) {
		if (name == "") {
			System.out.println("대화명을 입력하세요");
			System.out.println("ex)java Main aaa");
			System.exit(0);
		} else {
			this.name = name;
		}
	}
	
	public void sendLog(String log) {
		clientSender.run(log);
	}
	
	public void getLog(String log) {
		controller.getLog(log);
	}

	
}