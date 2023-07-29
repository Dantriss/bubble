package com.gameproject.bubble.test.ex06;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable{
    private BufferedImage image;
    private Player player;          //컴포지션

    public BackgroundPlayerService(Player player) {
        this.player = player;
        try {
            image = ImageIO.read(new File("image/backgroundMapService.png"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        //색상확인
        while (true){
        Color leftColor = new Color(image.getRGB(player.getX() -10, player.getY()+25));
        Color rightColor = new Color(image.getRGB(player.getX()+50+15, player.getY()+25));
//        System.out.println("left컬러확인 : "+leftColor);
//        System.out.println("right컬러확인 : "+rightColor);

        if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() ==0) {
            System.out.println("왼쪽벽에 충돌");
        }else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() ==0){
            System.out.println("오른쪽벽에 충돌");
        }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
