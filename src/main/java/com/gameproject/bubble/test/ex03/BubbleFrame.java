package com.gameproject.bubble.test.ex03;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);
        player = new Player();
        add(player);
//        backgroundMap.setSize(100,100);
//        backgroundMap.setLocation(300, 300);
//        backgroundMap.setSize(1000,600);
//        add(backgroundMap);                                  //JFrame에 JLabel이 그려진다.
    }
    private void initSetting(){
        setSize(1000,640);
        setLayout(null);                    // absolteLayout (자유롭게 배치 가능)
        setLocationRelativeTo(null);                        // JFrame 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // x 버튼으로 창을 끌때 JVM 같이 끄기
    }

    private void initListener(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e.getKeyCode());

                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        player.left();
                    break;
                    case KeyEvent.VK_RIGHT:
                        player.right();
                    break;
                    case KeyEvent.VK_DOWN:
                        player.down();
                    break;
                    case KeyEvent.VK_UP:
                        player.up();
                    break;
                }

            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
