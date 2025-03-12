package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mxcoogi
 * @version : lv3
 *
 */
public class Main {

    /**
     *
     * @param args
     * 키오스크 객체를 생성
     * start함수로 키오스크 실행
     */
    public static void main(String[] args){

        Kiosk kiosk = new Kiosk();
        kiosk.start();

    }
}