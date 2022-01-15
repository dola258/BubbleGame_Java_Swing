package bubbleGame.test.ex07;

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
			image = ImageIO.read(new File("image/BackgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void run() {
		// 색상 확인
		while(true) {
			
			Color leftcolor = new Color(image.getRGB(player.getX() -10, player.getY() + 25));
			Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
		//	System.out.println("왼쪽 색상 : " + leftcolor);
		//	System.out.println("오른쪽 색상 : " + rightcolor);

			if(leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {
			//	System.out.println("왼쪽 벽에 충돌 발생!!!!");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if(rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
			//	System.out.println("오른쪽 벽에 충돌 발생!!!!");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
