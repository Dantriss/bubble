package com.gameproject.bubble.test.ex11;

/*
* default를 사용하면 인터페이스도 몸체가 있는 메서드를 만들수 있다(다중 상속이 안되는것이 많기 때문)
* 그렇기 때문에 adapter 패턴보다 default를 사용하는 것이 좋음
* */
public interface Moveable {

    public abstract void up();
    default public void down() {};
    public abstract void left();
    public abstract void right();
}
