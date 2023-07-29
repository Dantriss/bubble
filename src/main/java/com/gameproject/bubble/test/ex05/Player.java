package com.gameproject.bubble.test.ex05;

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

    //플레이어 속도 상태
    private final int SPEED = 3;

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

    // left+up, right+up 가능해야함
    @Override
    public void up() {
        System.out.println("up");
        up = true;


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
                x = x - SPEED;
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
                x=x+SPEED;
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
