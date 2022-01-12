package bubbleGame.test.ex01;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

// 1. 윈도우 창이 되었음
// 2. 윈도우 창은 내부에 패널을 하나 가지고 있다
public class BubbleFrame extends JFrame {

	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(56, 98, 97, 23);
		getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("123156");
		textArea.setBounds(148, 307, 178, 24);
		getContentPane().add(textArea);
		setVisible(true); // 그림을 그려라
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
