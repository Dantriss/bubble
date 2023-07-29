package com.gameproject.bubble.test.ex12;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame(){
        initObject();
        initSetting();
        initListener();
        setVisible(true);
    }


    private void initObject(){
//        backgroundMap = new JLabel(new ImageIcon("image/backgroundMapService.png"));
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);
        player = new Player();
        add(player);
                                 //JFrame에 JLabel이 그려진다.
    }
    private void initSetting(){
        setSize(1000,640);
        setLayout(null);                    // absolteLayout (자유롭게 배치 가능)
        setLocationRelativeTo(null);                        // JFrame 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // x 버튼으로 창을 끌때 JVM 같이 끄기
    }

    private void initListener(){
        //키보드 눌렀을때 이벤트 핸들러
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:

                        if (!player.isLeft() && !player.isLeftWallCrash()){
                            player.left();
                        }

                    break;
                    case KeyEvent.VK_RIGHT:

                        if (!player.isRight() && !player.isRightWallCrash()){
                            player.right();
                        }

                    break;

                    case KeyEvent.VK_DOWN:
                    break;

                    case KeyEvent.VK_UP:
                        if (!player.isUp()&&!player.isDown()){
                            player.up();
                        }
                        break;

                    case KeyEvent.VK_SPACE:
                        Bubble bubble = new Bubble(player);
                        add(bubble);
                        break;

                }

            }

            //키보드 해제 이벤트 핸들러
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        player.setRight(false);
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setLeft(false);
                        break;
                    case KeyEvent.VK_UP:
                        player.setUp(false);
                        break;

                }
            }

        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
