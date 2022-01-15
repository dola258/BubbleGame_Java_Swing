package bubbleGame.test.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 메인 스레드는 바쁘다 - 키보드 이벤트를 처리하기 바쁘다
// 새로운 스레드 - 백그라운드에서 플레이어를 계속 관찰
public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("image/test.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void run() {
		// 색상 확인
		while(true) {
			Color leftcolor = new Color(image.getRGB(player.getX() -10, player.getY() + 25));
			Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			System.out.println("왼쪽 색상 : " + leftcolor);
			System.out.println("오른쪽 색상 : " + rightcolor);

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
