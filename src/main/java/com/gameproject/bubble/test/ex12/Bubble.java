package com.gameproject.bubble.test.ex12;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {

    // 의존성 컴포지션
    private Player player;      //컴포지션
    private BackgroundBubbleService backgroundBubbleService;

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
        initThread();
    }

    private void initObject(){
        bubble =  new ImageIcon("image/bubble.png");
        bubbleHit =  new ImageIcon("image/bubbled.png");
        bubbleBomb =  new ImageIcon("image/bomb.png");
        backgroundBubbleService = new BackgroundBubbleService(this);
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
    //버블은 스레드 하나만 필요
    private void initThread(){
        new Thread(()->{
            if(player.getPlayerDirection() == PlayerDirection.LEFT){
                left();
            }else {
                right();
            }
        })
        .start();
    }

    @Override
    public void up() {
        up = true;
        while (true){
            y--;
            setLocation(x,y);

            if (backgroundBubbleService.upWall()){
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void left() {
        left = true;
        for (int i = 0; i < 400; i++) {
            x--;
            setLocation(x,y);

            if (backgroundBubbleService.leftWall()){
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        up();
    }

    @Override
    public void right() {
        right = true;
        for (int i = 0; i < 400; i++) {
            x++;
            setLocation(x,y);
            if (backgroundBubbleService.rightWall()){
                break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        up();
    }
}
