package com.spring.springcore.singleton;

public class SingleTonService {

    // static 으로 가지게 되면 class 레벨에 딱 하나만 가지게 된다.
    // static 영역에 하나만. !
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    private SingleTonService() {
    }

    public void logic() {
        System.out.println(" 싱글톤 로직 호출 ");
    }

}
