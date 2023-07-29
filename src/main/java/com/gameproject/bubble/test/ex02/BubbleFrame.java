package com.gameproject.bubble.test.ex02;

import javax.swing.*;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame(){
        initObject();
        initSetting();
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
    public static void main(String[] args) {
        new BubbleFrame();
    }
}
