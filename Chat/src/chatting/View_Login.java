package chatting;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View_Login extends JFrame implements ActionListener {

	private Controller c;
	private KeyListener k;
	private JPanel loginPane;
	private JTextField nickNameField;
	private JButton enterButton;

	public View_Login() {

		setTitle("닉네임 입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 130);
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		loginPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		enterButton = new JButton("입장");
		enterButton.addActionListener(this);
		panel.add(enterButton);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		loginPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2, BorderLayout.NORTH);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, BorderLayout.SOUTH);

		nickNameField = new JTextField();
		nickNameField.setFont(new Font("굴림", Font.BOLD, 18));
		nickNameField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(nickNameField, BorderLayout.CENTER);
		nickNameField.setColumns(10);
		nickNameField.registerKeyboardAction(this, "enter", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2, BorderLayout.WEST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3, BorderLayout.EAST);

	}

	public void setController(Controller c) {
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton || e.getActionCommand() == "enter") {
			c.setNickname(nickNameField.getText());
			c.openChat();
			System.out.println("1이름 = "+nickNameField.getText());
			
			this.setVisible(false);
		}
	}
}
