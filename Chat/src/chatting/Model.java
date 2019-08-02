package chatting;

public class Model {

	private String NickName;
	private int port = 3100;
	private String IpAdress = "218.39.221.86";

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
		System.out.println("3이름 = "+nickName);
	}

	

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIpAdress() {
		return IpAdress;
	}

	public void setIpAdress(String ipAdress) {
		IpAdress = ipAdress;
	}

}
