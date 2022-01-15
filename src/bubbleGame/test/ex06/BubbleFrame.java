package bubbleGame.test.ex06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	
	private JLabel backgroundMap;
	private Player player;
	
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();  // 이벤트 리스너
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/BackgroundMap.png"));

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
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {
			
			// 키보드가 눌러졌을 때 이벤트 핸들러
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if(!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				}
			}
		
			// 키보드가 떨어졌을 때 이벤트 핸들러
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}
		}); 		
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
