package bubbleGame.test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	
	private JLabel backgroundMap;
	private Player player;
	
	
	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

	//	크기 조절
	//	backgroundMap.setSize(1000,600); 
	//  위치 조절	
	//	backgroundMap.setLocation(300, 300);
	//  JFrame에 JLabel이 그려진다 
	//	add(backgroundMap); 
		
	//  JPanel 자체를 JLabel(backgroundMap)으로 변경하기	
		setContentPane(backgroundMap);
	
		player = new Player(); // player new하기
		add(player);           // 배경에 캐릭터 추가하기
	}
	
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); // null (화면 가운데에 뜬다)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼으로 창을 끌 때 JVM도 같이 종료하기
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
