package com.gameproject.bubble.test.ex11;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
@Getter
@Setter
public class Player extends JLabel implements Moveable {

    // 위치 상태
    private int x;
    private int y;

    // 플레이어의 방향
    private PlayerDirection playerDirection;

    // 움직임상태
    boolean left;
    boolean right;
    boolean up;
    boolean down;

    // 벽에 충돌한 상태
    boolean leftWallCrash;
    boolean rightWallCrash;

    //플레이어 속도 상태
    private final int SPEED = 5;
    private final int JUMPSPEED = 2;

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
        initBackgroundPlayerService();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");

    }

    private void initSetting() {
        x = 80;
        y = 538;

        right = false;
        left = false;
        up = false;
        down = false;

        leftWallCrash = false;
        rightWallCrash = false;

        playerDirection = PlayerDirection.RIGHT;


        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    private void initBackgroundPlayerService() {
        new Thread(new BackgroundPlayerService(this)).start();
    }


    public static void main(String[] args) {

    }

    // left+up, right+up 가능해야함
    @Override
    public void up() {

//        if (up == false && down==false){

//            System.out.println("up");
            up = true;
            new Thread(()->{
                for (int i = 0; i < 120/JUMPSPEED; i++) {
                    y = y-(JUMPSPEED)-1;
                    setLocation(x,y);
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                up = false;
                down();
            }).start();
//        }

    }

    @Override
    public void down() {
//            System.out.println("down");
            down = true;
            new Thread(()->{
                while (down) {
//                for (int i = 0; i < 115/JUMPSPEED; i++) {


                    y = y+(JUMPSPEED);
                    setLocation(x,y);
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                down = false;
            }).start();


    }


    // 이벤트 핸들러
    @Override
    public void left() {
        playerDirection = PlayerDirection.LEFT;
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
        playerDirection = PlayerDirection.RIGHT;
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
