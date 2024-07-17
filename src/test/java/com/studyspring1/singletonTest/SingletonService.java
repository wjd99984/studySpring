package com.studyspring1.singletonTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    // 1. static 영역의 객체를 각 1개만 생성해준다
    // static 으로 생성했기 떄문에 클래스로 선언 되어 하나만 가짐
    private static final SingletonService instance = new SingletonService();


    public static SingletonService getInstance() {
        return instance;
    }

    //private 선언하여 외부에서 new 키워드를 사용한 객체생성 막음
    private SingletonService() {}

    public void login() {
        System.out.println("싱글을 객체  호출");
    }



}
