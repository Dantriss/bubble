package com.gameproject.bubble.test.ex03;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

import javax.swing.*;

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

    @Override
    public void left() {
        setIcon(playerL);
        x = x - 10;
        setLocation(x,y);
    }

    @Override
    public void right() {
        setIcon(playerR);
        x = x +10;
        setLocation(x,y);
    }
}
