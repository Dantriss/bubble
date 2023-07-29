package com.gameproject.bubble.test.ex04;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
@Getter
@Setter
public class Player extends JLabel implements Moveable {

    // 위치 상태
    private int x;
    private int y;

    // 움직임상태
    boolean left;
    boolean right;
    boolean up;
    boolean down;

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");

    }

    private void initSetting() {
        x = 55;
        y = 535;

        right = false;
        left = false;
        up = false;
        down = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public static void main(String[] args) {

    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }


    // 이벤트 핸들러
    @Override
    public void left() {
        System.out.println("left thread 생성");

        left = true;

        new Thread(() ->{
            while (left){
                setIcon(playerL);
                x = x - 10;
                setLocation(x,y);
                try {
                    Thread.sleep(10);   //0.01초
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    @Override
    public void right() {
        right = true;
        new Thread(()->{
            while (right){
                setIcon(playerR);
                x=x+10;
                setLocation(x,y);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }).start();


    }
}
