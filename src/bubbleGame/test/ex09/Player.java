
package bubbleGame.test.ex09;

import java.util.Iterator;	

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

// class Player -> new 가능한 애들! 게임에 존재할 수 있음(추상메서드를 가질 수 없음)
// 무조건 구현을 해야하는 의무를 가진다
@Getter
@Setter
public class Player extends JLabel implements Moveable {

	// 위치 상태
	private int x;
	private int y;
	
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2; // UP, DOWN의 스피드
	
	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
		initBackgroundTPlayerService();
	}


	private void initBackgroundTPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 80;
		y = 535;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;

		this.setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
		
	}

	@Override
	public void left() {
	//	System.out.println("left");
		left = true;
		new Thread(() -> {
			while(left) {
				setIcon(playerL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void right() {
	//	System.out.println("right");
		right = true;
		new Thread(() -> {
			while(right) {
				setIcon(playerR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// left + up (왼쪽으로 가면서 점프), right + up (오른쪽으로 가면서 점프)
	@Override
	public void up() {
	//	System.out.println("up");
		up = true;
		new Thread(() -> {
			for(int i=0; i<130/JUMPSPEED; i++) { // JUMPSPEED가 1일 때 130이 가장 적당했다
				y = y - JUMPSPEED; // 점프를 하면 y좌표는 -가 된다! 
				setLocation(x, y);
				try {
					Thread.sleep(5); // 0.005초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
		}).start();
	}

	@Override
	public void down() {
	//	System.out.println("down");
		down = true;
		new Thread(() -> {
			while(down
					) {
				y = y + JUMPSPEED; 
				setLocation(x, y);
				try {
					Thread.sleep(3); // 0.003초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			down = false;
			
		}).start();
	}
}
