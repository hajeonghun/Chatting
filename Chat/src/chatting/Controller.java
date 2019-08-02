package chatting;

import java.awt.EventQueue;

public class Controller {

	View_Chatting chat;
	View_Login login;
	Model m;
	ChattingClient chattingclient;
	
	public Controller() {
		m = new Model();
	}

	public void setNickname(String name) {
		m.setNickName(name);
	}

	public void setPort(String port) {
		m.setNickName(port);
	}

	public void setIpadress(String ip) {
		m.setNickName(ip);
	}

	public int getPort() {
		return m.getPort();
	}

	public String getNickname() {
		return m.getNickName();
	}

	public String getIpadress() {
		return m.getIpAdress();
	}

	public void openChat() {
		EventQueue.invokeLater(() -> {
			try {
				chat = new View_Chatting();
				chat.setController(Controller.this);
				chat.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		chattingclient=new ChattingClient(
				m.getNickName(),
				m.getIpAdress(),
				m.getPort(),
				this
				);
	}

	public void openLogin() {
		EventQueue.invokeLater(() -> {
			try {
				login = new View_Login();
				login.setController(Controller.this);
				login.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public String getLog() {
		String log = new String();
		// 서버로부터 화면에 띄울 채팅 내용을 받아오면 return 해주는 곳

		return log;
	}

	public void sendLog(String log) {
		// 내가 전송할 문자열을 서버로 보낼 그런 함수 넣는 곳
		chattingclient.sendLog(log);
	}
	public void getLog(String log) {
		chat.update(log);
	}
}
