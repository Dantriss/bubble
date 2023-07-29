package com.gameproject.bubble.test.ex10;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;

import javax.swing.*;

@Getter
@Setter
public class Bubble extends JLabel {


    private Player player;      //컴포지션

    // 위치 상태
    private int x;
    private int y;

    // 움직임상태
    private boolean left;
    private boolean right;
    private boolean up;

    // 적군을 맞춘 상태
    private int state; // 0(물방울), 1(적을 가둔 물방울)

    private ImageIcon bubble;       // 물방울
    private ImageIcon bubbleHit;    // 적을 가둔 물방울
    private ImageIcon bubbleBomb;   // 물방울이 터진 상태


    public Bubble(Player player) {
        this.player = player;
        initObject();
        initSetting();
    }

    private void initObject(){
        bubble =  new ImageIcon("image/bubble.png");
        bubbleHit =  new ImageIcon("image/bubbled.png");
        bubbleBomb =  new ImageIcon("image/bomb.png");
    }

    private void initSetting(){
        up = false;
        left = false;
        right = false;

        x = player.getX();
        y = player.getY();

        setIcon(bubble);
        setSize(50,50);
        state = 0;

    }

}
