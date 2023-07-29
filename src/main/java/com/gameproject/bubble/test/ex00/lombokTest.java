package com.gameproject.bubble.test.ex00;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
class Dog{
    private String name;
}
@Component
public class lombokTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.setName("뽀삐");
        System.out.println("멍멍이 이름 : "+d.getName());
    }
}
